package com.example.ebook;

import java.io.File;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class File_search extends ListActivity {
	String uzanti = "/.pdf";
	private File sdcardObj = new File(Environment.getExternalStorageDirectory()
			.getAbsolutePath());
	private ArrayList<String> filelist = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);

		// File file[] = Environment.getExternalStorageDirectory().listFiles();
		// recursiveFileFind(file);

		// dismiss the dialog after the file was downloaded

		// String fileName = uzanti.substring(uzanti.lastIndexOf('/') + 1,
		// uzanti.length());

		// Toast.makeText(File_search.this, fileName, Toast.LENGTH_LONG).show();
		// Displaying downloaded image into image view
		// Reading image path from sdcard
		// String imagePath =
		// Environment.getExternalStorageDirectory().toString();
		// setting downloaded into image view
		// my_image.setImageDrawable(Drawable.createFromPath(imagePath));

		// String sdRootDir =
		// Environment.getExternalStorageDirectory().toString() + "/" +
		// fileName;
		// printfiles(new File(imagePath));

		ListView listView = getListView();

	}

	/*
	 * public void printfiles(File file) {
	 * 
	 * File[] list = file.listFiles(); Log.i("DIR",
	 * "The full PATH to the sdcard location is:" + file.getPath()); for (int i
	 * = 0; i < list.length; i++) {
	 * 
	 * // myList.add( list[i].getName() ); File temp_file = new
	 * File(file.getAbsolutePath(), list[i].getName());
	 * 
	 * if (temp_file.isDirectory() && temp_file.listFiles() != null) {
	 * Log.i("DIR", "PATH" + temp_file.getAbsolutePath()); // I am inside The
	 * Directory... Searching:) So i am calling // printfiles(File file)
	 * function to print the files in the // directory
	 * Log.i("I am inside The Directory... Searching:)",
	 * "Printing the files in the directory"); printfiles(temp_file); } else {
	 * Log.i("File", "PATH" + temp_file.getAbsolutePath()); } } }
	 */
	public void recursiveFileFind(File[] file1) {
		int i = 0;
		String filePath = "";
		if (file1 != null) {
			while (i != file1.length) {
				filePath = file1[i].getAbsolutePath();
				String fileName = uzanti.substring(uzanti.lastIndexOf('/') + 1,
						uzanti.length());

				String filename = file1[i].getName();
				String ext = filename.substring(filename.lastIndexOf('.') + 1,
						filename.length());

				if (file1[i].isDirectory()) {
					File file[] = file1[i].listFiles();
					recursiveFileFind(file);
				}
				i++;
				Log.d(i + "", filePath);
			}
		}
	}

	private void listFiles(File sdcard, ArrayList<String> filelist) {
		if (sdcard.isDirectory()) {
			File[] files = sdcard.listFiles();

			try {
				for (File f : files) {
					if (!f.isDirectory()) {
						if (f.getName().endsWith(".doc")
								|| f.getName().endsWith(".txt")
								|| f.getName().endsWith(".docx")
								|| f.getName().endsWith(".rtf")
								|| f.getName().endsWith(".pdf")) {
							// Log.d(" FILES",f.getName());
							// Log.i("File", "PATH" + f.getAbsolutePath());
							this.filelist.add(f.getAbsolutePath());
							this.setListAdapter(new ArrayAdapter<String>(this,
									R.layout.activity_file_search,
									R.id.listitem, filelist));
						}
					} else {
						this.listFiles(f, this.filelist);

					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}

	}

}