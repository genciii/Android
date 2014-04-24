package com.example.ebook;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button Parlaklik;
	private Button Kut;
	private Button Aram;
	private Button Visus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); // Tepedeki bari
															// siler
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); // notification
																// barini siler

		setContentView(R.layout.activity_main);
		Parlaklik = (Button) findViewById(R.id.butParlak);
		Kut = (Button) findViewById(R.id.butLibrary);
		Visus = (Button) findViewById(R.id.butVisus);
		Aram = (Button) findViewById(R.id.butSearch);
		Parlaklik.setOnClickListener(this);
		Kut.setOnClickListener(this);
		Visus.setOnClickListener(this);
		Aram.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
			//Ana menudeki butunlarin gidecegi activite ve linkler
		if (Parlaklik.isPressed()) {
			Intent i = new Intent(MainActivity.this, Brightness.class);
			MainActivity.this.startActivity(i);

		}

		if (Kut.isPressed()) {
			Intent i = new Intent(MainActivity.this, Library.class);
			MainActivity.this.startActivity(i);

		}
		

		if (Aram.isPressed()) {
			Intent i = new Intent(MainActivity.this, File_search2.class);
			MainActivity.this.startActivity(i);

		}


		else if (Visus.isPressed()) {
			Uri uri = Uri.parse("http://www.visustek.com.tr");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			this.startActivity(intent);
		}

	}

}
