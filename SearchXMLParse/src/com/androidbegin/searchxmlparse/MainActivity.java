package com.androidbegin.searchxmlparse;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.devsmart.android.ui.HorizontalListView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	// Declare Variables
	HorizontalListView listview;
	ListViewAdapter adapter;
	ProgressDialog mProgressDialog;
	static String RANK = "rank";
	static String COUNTRY = "country";
	static String POPULATION = "population";
	static String FLAG = "thumb_url";
	EditText editsearch;
	private List<WorldPopulation> worldpopulationlist = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from listview_main.xml
		setContentView(R.layout.listview_main);
		// Execute DownloadXML AsyncTask
		new DownloadXML().execute();
	}

	// DownloadXML AsyncTask
	private class DownloadXML extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Create a progressdialog
			mProgressDialog = new ProgressDialog(MainActivity.this);
			// Set progressdialog title
			mProgressDialog.setTitle("Android Search Filter XML Parse");
			// Set progressdialog message
			mProgressDialog.setMessage("Loading...");
			mProgressDialog.setIndeterminate(false);
			// Show progressdialog
			mProgressDialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			// Create the array
			worldpopulationlist = new ArrayList<WorldPopulation>();
			XMLParser parser = new XMLParser();
			// Retrive nodes from the given website URL in XMLParser.class
			String xml = parser
					.getXmlFromUrl("http://gencaydeniz.com/wp-content/uploads/2014/04/music.xml");
			// Retrive DOM element
			Document doc = parser.getDomElement(xml);

			try {
				// Locate the NodeList name
				NodeList nl = doc.getElementsByTagName("song");
				for (int i = 0; i < nl.getLength(); i++) {
					Element e = (Element) nl.item(i);
					WorldPopulation map = new WorldPopulation();
				//	map.setRank(parser.getValue(e, RANK));
				//	map.setCountry(parser.getValue(e, COUNTRY));
					map.setPopulation(parser.getValue(e, POPULATION));
					map.setFlag(parser.getValue(e, FLAG));
					
					worldpopulationlist.add(map);
				}
			} catch (Exception e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void args) {
			// Locate the listview in listview_main.xml
			listview = (HorizontalListView) findViewById(R.id.listview);
			// Pass the results into ListViewAdapter.java
			adapter = new ListViewAdapter(MainActivity.this,
					worldpopulationlist);
			// Binds the Adapter to the ListView
			listview.setAdapter(adapter);
			// Close the progressdialog
			mProgressDialog.dismiss();
			// Locate the EditText in listview_main.xml
			editsearch = (EditText) findViewById(R.id.search);

			// Capture Text in EditText
			editsearch.addTextChangedListener(new TextWatcher() {

				@Override
				public void afterTextChanged(Editable arg0) {
					// TODO Auto-generated method stub
					String text = editsearch.getText().toString()
							.toLowerCase(Locale.getDefault());
					adapter.filter(text);
				}

				@Override
				public void beforeTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {
					// TODO Auto-generated method stub
				}

				@Override
				public void onTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {
					// TODO Auto-generated method stub
				}
			});
		}
	}
}