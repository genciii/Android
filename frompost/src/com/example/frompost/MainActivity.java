package com.example.frompost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private String value2;
	private EditText value;
	private Button btn;
	private ProgressBar pb;
	private ListView liste;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		value = (EditText) findViewById(R.id.editText1);
		btn = (Button) findViewById(R.id.button1);
		pb = (ProgressBar) findViewById(R.id.progressBar1);
		// String[] sehirler = getResources().getStringArray(R.array.Sehirler);
		pb.setVisibility(View.GONE);
		btn.setOnClickListener(this);
		// String[] values = new String[] { "Android", "iPhone",
		// "WindowsMobile",
		// "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		// "Linux", "OS/2" };
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// R.layout.activity_main,android.R.id.list, values);
		// setListAdapter(adapter);

	//	String[] adobe_products = getResources().getStringArray(
	//			R.array.Sehirler);

		// Binding resources Array to ListAdapter
	//	this.setListAdapter(new ArrayAdapter<String>(this,
	//			R.layout.activity_main, R.id.label, adobe_products));

	//	ListView lv = getListView();

		// listening to single list item on click
	//	lv.setOnItemClickListener(new OnItemClickListener() {
	//		public void onItemClick(AdapterView<?> parent, View view,
		//			int position, long id) {

				// selected item
		//		String product = ((TextView) view).getText().toString();

				// String sehir = ((TextView) v).getText().toString();
			//	new MyAsyncTask().execute(product.toString());
		//	}
	//	});

	//}

	// protected void onListItemClick(ListView l, View v, int position, long id)
	// {
	// String sehir = ((TextView) v).getText().toString();
	// new MyAsyncTask().execute(sehir.toString());

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (value.getText().toString().length() < 1) {

			// out of range
			Toast.makeText(this, "Boþluklarý dolduralým lütfen...", Toast.LENGTH_LONG)
					.show();
		} else {
			pb.setVisibility(View.VISIBLE);
			new MyAsyncTask().execute(value.getText().toString());
		}

	}

	private class MyAsyncTask extends AsyncTask<String, Integer, Double> {

		@Override
		protected Double doInBackground(String... params) {
			// TODO Auto-generated method stub
			postData(params[0]);
			return null;
		}

		protected void onPostExecute(Double result) {
			pb.setVisibility(View.GONE);
			Toast.makeText(getApplicationContext(), "yollandý bil...",
					Toast.LENGTH_LONG).show();
		}

		protected void onProgressUpdate(Integer... progress) {
			pb.setProgress(progress[0]);
		}

		public void postData(String valueIWantToSend) {
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://gencaydeniz.com/time.php");

			try {
				// Add your data
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("message",
						valueIWantToSend));
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

				// Execute HTTP Post Request
				HttpResponse response = httpclient.execute(httppost);

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		}

	}

}
