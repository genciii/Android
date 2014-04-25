package com.example.androidhive;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.devsmart.android.ui.HorizontalListView;

public class CustomizedListView extends Activity {
	// All static variables
	static final String URL = "http://api.androidhive.info/music/music.xml";
	// XML node keys
	static final String KEY_SONG = "song"; // parent node
	static final String KEY_ID = "id";
	static final String KEY_TITLE = "title";
	static final String KEY_ARTIST = "artist";
	static final String KEY_DURATION = "duration";
	static final String KEY_THUMB_URL = "thumb_url";

	ListView list;
	LazyAdapter adapter;
	HorizontalListView listview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewdemo);

		ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(URL); // getting XML from URL
		Document doc = parser.getDomElement(xml); // getting DOM element

		NodeList nl = doc.getElementsByTagName(KEY_SONG);
		// looping through all song nodes <song>
		for (int i = 0; i < nl.getLength(); i++) {
			// creating new HashMap
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(i);
			// adding each child node to HashMap key => value
			map.put(KEY_ID, parser.getValue(e, KEY_ID));
			map.put(KEY_TITLE, parser.getValue(e, KEY_TITLE));
			map.put(KEY_ARTIST, parser.getValue(e, KEY_ARTIST));
			map.put(KEY_DURATION, parser.getValue(e, KEY_DURATION));
			map.put(KEY_THUMB_URL, parser.getValue(e, KEY_THUMB_URL));

			// adding HashList to ArrayList
			songsList.add(map);
		}

		listview = (HorizontalListView) findViewById(R.id.listview);

		// Getting adapter by passing xml data ArrayList
		adapter = new LazyAdapter(this, songsList);
		listview.setAdapter(adapter);

		// LinearLayout mainLayout =
		// (LinearLayout)findViewById(R.id.main_layout);
		// View view = getLayoutInflater().inflate(R.layout.list_row,null);
		// ImageView image = (ImageView) view.findViewById(R.id.list_image);
		// mainLayout.addView(view);

		// Click event for single list row
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// Adele
				if (position == 0) {
					Uri uri = Uri.parse("http://en.wikipedia.org/wiki/Adele");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					CustomizedListView.this.startActivity(intent);
				}
				if (position == 1) {
					Uri uri = Uri.parse("http://en.wikipedia.org/wiki/Eminem");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					CustomizedListView.this.startActivity(intent);
				}
				if (position == 2) {
					Uri uri = Uri
							.parse("http://en.wikipedia.org/wiki/Michael_Jackson");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					CustomizedListView.this.startActivity(intent);
				}
				if (position == 3) {
					Uri uri = Uri.parse("http://en.wikipedia.org/wiki/Rihanna");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					CustomizedListView.this.startActivity(intent);
				}
				if (position == 4) {
					Uri uri = Uri.parse("http://en.wikipedia.org/wiki/A._R._Rahman");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					CustomizedListView.this.startActivity(intent);
				}
				if (position == 5) {
					Uri uri = Uri.parse("http://en.wikipedia.org/wiki/Alexi_Murdoch");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					CustomizedListView.this.startActivity(intent);
				}
				if (position == 6) {
					Uri uri = Uri.parse("http://en.wikipedia.org/wiki/Dido_(singer)");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					CustomizedListView.this.startActivity(intent);
				}
				if (position == 7) {
					Uri uri = Uri
							.parse("http://en.wikipedia.org/wiki/Enrique_Iglesias");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					CustomizedListView.this.startActivity(intent);
				}
				if (position == 8) {
					Uri uri = Uri
							.parse("http://en.wikipedia.org/wiki/Ennio_Morricone");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					CustomizedListView.this.startActivity(intent);
				}
				if (position == 9) {
					Uri uri = Uri
							.parse("http://en.wikipedia.org/wiki/Backstreet_Boys");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					CustomizedListView.this.startActivity(intent);
				}

			}

		});

	}

}