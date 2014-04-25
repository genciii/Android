package com.example.ebook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Asynctask extends Activity {

	List<File> txtList;//

	EditText editText;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asynctask);

		this.setTitle("DEMO(SD)");
		Button btnPhoto = (Button) findViewById(R.id.button);
		editText = (EditText) findViewById(R.id.edittext);
		txtList = new ArrayList<File>();
		btnPhoto.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				new AsyncTask<Integer, Integer, String[]>() {

					private ProgressDialog dialog;

					protected void onPreExecute() {
						dialog = ProgressDialog.show(Asynctask.this, "",
								"SD,....");
						super.onPreExecute();
					}

					protected String[] doInBackground(Integer... params) {
						if (!android.os.Environment.getExternalStorageState()
								.equals(android.os.Environment.MEDIA_MOUNTED)) {

						} else {
							if (!editText.getText().toString().equals("")) {
								GetFiles(Environment
										.getExternalStorageDirectory());
							}
						}
						return null;
					}

					protected void onPostExecute(String[] result) {
						dialog.dismiss();
						if (editText.getText().toString().equals("")) {
							Toast.makeText(Asynctask.this, "",
									Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(Asynctask.this, "",
									Toast.LENGTH_LONG).show();
							Intent in = new Intent();
							in.setClass(Asynctask.this, ListOk2.class);
							Asynctask.this.startActivity(in);
						}
						super.onPostExecute(result);
					}
				}.execute(0);
			}
		});

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
					if (files[i].getName().toLowerCase()
							.endsWith("." + editText.getText().toString())) {
						txtList.add(files[i]);
					}
				}
			}
		}
	}

}
