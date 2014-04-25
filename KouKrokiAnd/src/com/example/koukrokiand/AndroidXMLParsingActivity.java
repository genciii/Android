package com.example.koukrokiand;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

public class AndroidXMLParsingActivity extends Activity implements
		OnItemClickListener {
	GridView mListView;

	Button mExit;
	Button mRefresh;
	Button mClear;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setProgressBarIndeterminateVisibility(false);

		setContentView(R.layout.activity_android_xmlparsing);
		mListView = (GridView) findViewById(R.id.listView1);
		mListView.setTextFilterEnabled(true);
		mListView.setOnItemClickListener(this);

		mRefresh = (Button) findViewById(R.id.button1);
		mRefresh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				LoadRecipesTask mLoadRecipesTask = new LoadRecipesTask();
				mLoadRecipesTask
						.execute("http://gencaydeniz.com/gencaydeniz.com/anonymous/documents/list.xml");
			}
		});

		mClear = (Button) findViewById(R.id.button2);
		mClear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mListView.setAdapter(null);
			}
		});

		mExit = (Button) findViewById(R.id.button3);
		mExit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}

	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if (position == 2) {
			Uri uri = Uri.parse("http://bilgisayar.kocaeli.edu.tr/");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			this.startActivity(intent);
		}
		if (position == 3) {
			Uri uri = Uri.parse("http://cevre.kocaeli.edu.tr/");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			this.startActivity(intent);
		}
		if (position == 4) {
			Uri uri = Uri.parse("http://elektrik.kocaeli.edu.tr/");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			this.startActivity(intent);
		}
		if (position == 5) {
			Uri uri = Uri.parse("http://ehm.kocaeli.edu.tr/web/index.php");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			this.startActivity(intent);
		}
		if (position == 6) {
			Uri uri = Uri.parse("http://endustri.kocaeli.edu.tr/");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			this.startActivity(intent);
		}
		if (position == 7) {
			Uri uri = Uri.parse("http://harita.kocaeli.edu.tr/");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			this.startActivity(intent);
		}
		if (position == 8) {
			Uri uri = Uri.parse("http://insaat.kocaeli.edu.tr/");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			this.startActivity(intent);
		}
		if (position == 16) {
			Uri uri = Uri.parse("http://mf.kocaeli.edu.tr/Iletisim.php");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			this.startActivity(intent);
		}

	}

	public static ArrayList<Datum> parse(String url) throws IOException,
			XmlPullParserException {
		final ArrayList<Datum> results = new ArrayList<Datum>();

		URL input = new URL(url);

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser xpp = factory.newPullParser();

		xpp.setInput(input.openStream(), null);
		int eventType = xpp.getEventType();
		String currentTag = null;
		Integer id = null;
		String title = null;
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_TAG) {
				currentTag = xpp.getName();
			} else if (eventType == XmlPullParser.TEXT) {
				if ("id".equals(currentTag)) {
					id = Integer.valueOf(xpp.getText());
				}
				if ("title".equals(currentTag)) {
					title = xpp.getText();
				}
			} else if (eventType == XmlPullParser.END_TAG) {
				if ("fak".equals(xpp.getName())) {
					results.add(new Datum(id, title));
				}
			}
			eventType = xpp.next();
		}
		return results;
	}

	protected class LoadRecipesTask extends
			AsyncTask<String, Void, ArrayList<Datum>> {

		@Override
		protected void onPreExecute() {
			AndroidXMLParsingActivity.this
					.setProgressBarIndeterminateVisibility(true);
		}

		@Override
		protected ArrayList<Datum> doInBackground(String... urls) {
			ArrayList<Datum> datumList = new ArrayList<Datum>();
			try {
				datumList = parse(urls[0]);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			}
			return datumList;
		}

		@Override
		protected void onPostExecute(ArrayList<Datum> result) {
			mListView
					.setAdapter(new ArrayAdapter<Datum>(
							AndroidXMLParsingActivity.this, R.layout.list_item,
							result));
			AndroidXMLParsingActivity.this
					.setProgressBarIndeterminateVisibility(false);
		}
	}

}
