package com.example.ebook;

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

public class Library extends Activity {

	// Sabit degiskenler
	static final String URL = "http://www.androidbegin.com/tutorial/xmlparseimgtxt.xml"; // Istenilen
																							// veriyi
																							// cekmek
																							// icin
																							// link
																							// degistirilmesi
																							// ve
																							// gerekli
																							// dugumlerin
																							// eklenmesi
																							// yeterlidir
	// XML uzerinden hangi verileri almak istiyorsak onlarin dugumleri...
	static final String KEY_RANK = "ranking"; // ana dugum
	static final String KEY_ID = "id";
	static final String KEY_THUMB_URL = "flag";

	ListView list;
	LazyAdapter adapter;
	HorizontalListView listview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewdemo);

		ArrayList<HashMap<String, String>> ranklist = new ArrayList<HashMap<String, String>>();

		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(URL); // xml i URL den alma
		Document doc = parser.getDomElement(xml); // Dom parsing elementi

		NodeList nl = doc.getElementsByTagName(KEY_RANK);
		// baslangic dugumu icin dugum sonuna kadar loop
		for (int i = 0; i < nl.getLength(); i++) {
			// Yeni hashmap
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(i);
			// Herbir dugumu hashmap key olarak ekleme
			map.put(KEY_ID, parser.getValue(e, KEY_ID));
			map.put(KEY_THUMB_URL, parser.getValue(e, KEY_THUMB_URL));

			// Olusturdugumuz Hashmaplisti ArrayListe yerlestirme
			ranklist.add(map);
		}

		// HorizontalListView Kutuphanesi ile yatay listview
		listview = (HorizontalListView) findViewById(R.id.listview);

		// Xml deki verileri adaptere parse etme
		adapter = new LazyAdapter(this, ranklist);
		listview.setAdapter(adapter);

		// listelenen elemanlarin tiklanabilir olmasi
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// Pozisyona gore listedeki elemanlarin gidecekleri sayfalarin
				// belirlenmesi (linkler rastgele atanmistir.)
				if (position == 0) {
					Uri uri = Uri.parse("http://en.wikipedia.org/wiki/China");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					Library.this.startActivity(intent);
				}
				if (position == 1) {
					Uri uri = Uri.parse("http://en.wikipedia.org/wiki/India");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					Library.this.startActivity(intent);
				}
				if (position == 2) {
					Uri uri = Uri
							.parse("http://en.wikipedia.org/wiki/United_States");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					Library.this.startActivity(intent);
				}
				if (position == 3) {
					Uri uri = Uri
							.parse("http://en.wikipedia.org/wiki/Indonesia");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					Library.this.startActivity(intent);
				}
				if (position == 4) {
					Uri uri = Uri.parse("http://en.wikipedia.org/wiki/Brazil");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					Library.this.startActivity(intent);
				}
				if (position == 5) {
					Uri uri = Uri
							.parse("http://en.wikipedia.org/wiki/Pakistan");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					Library.this.startActivity(intent);
				}
				if (position == 6) {
					Uri uri = Uri.parse("http://en.wikipedia.org/wiki/Nigeria");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					Library.this.startActivity(intent);
				}
				if (position == 7) {
					Uri uri = Uri
							.parse("http://en.wikipedia.org/wiki/Bangladesh");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					Library.this.startActivity(intent);
				}
				if (position == 8) {
					Uri uri = Uri.parse("http://en.wikipedia.org/wiki/Russia");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					Library.this.startActivity(intent);
				}
				if (position == 9) {
					Uri uri = Uri.parse("http://en.wikipedia.org/wiki/Japan");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					Library.this.startActivity(intent);
				}

			}

		});

	}

}