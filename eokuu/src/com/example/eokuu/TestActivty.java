package com.example.eokuu;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.widget.EditText;

public class TestActivty extends Activity {

	static List<File> txtList;

	EditText editText;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_activty);

		this.setTitle("Bulunan Dosyalar");

		txtList = new ArrayList<File>();

		new AsyncTask<Integer, Integer, String[]>() {

			private ProgressDialog dialog;

			protected void onPreExecute() {
				dialog = ProgressDialog.show(TestActivty.this, "",
						"Araniyor,....");
				super.onPreExecute();
			}

			protected String[] doInBackground(Integer... params) {
				if (!android.os.Environment.getExternalStorageState().equals(
						android.os.Environment.MEDIA_MOUNTED)) {

				} else {

					GetFiles(Environment.getExternalStorageDirectory());

				}
				return null;
			}

			protected void onPostExecute(String[] result) {
				dialog.dismiss();
				Intent in = new Intent();
				in.setClass(TestActivty.this, Liste.class);
				TestActivty.this.startActivity(in);
				// }
				super.onPostExecute(result);
			}
		}.execute(0);

	}

	/**
	 * 
	 * 
	 * @param filePath
	 */
	public void GetFiles(File filePath) {

		File[] files = filePath.listFiles();

		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					GetFiles(files[i]);
				} else {
					if (files[i].getName().endsWith(".java")
							|| files[i].getName().endsWith(".pdf")
							|| files[i].getName().endsWith(".html")
							|| files[i].getName().endsWith(".xml")) {
						txtList.add(files[i]);
					}
				}
			}
		}
	}

}