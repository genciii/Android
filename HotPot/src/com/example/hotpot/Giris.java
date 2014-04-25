package com.example.hotpot;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Giris extends Activity implements OnClickListener {
	Button giris;
	TextView gezin;
	Button uye;
	ImageView frame;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_giris);
		giris = (Button) findViewById(R.id.giris);
		uye = (Button) findViewById(R.id.uyeol);
		gezin = (TextView) findViewById(R.id.oyle);
		frame = (ImageView) findViewById(R.id.ImageView01);
		giris.setOnClickListener(this);
		uye.setOnClickListener(this);
		gezin.setOnClickListener(this);
		frame.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (giris.isPressed()) {
			Intent i = new Intent(Giris.this, Uyegiris.class);
			startActivity(i);
		} else if (uye.isPressed()) {
			Toast.makeText(getBaseContext(), "Yapým Aþamasýnda",
					Toast.LENGTH_LONG).show();
		} else if (gezin.isPressed()) {
			Toast.makeText(getBaseContext(), "Yapým Aþamasýnda",
					Toast.LENGTH_LONG).show();
		} else if (frame.isPressed()) {
			Uri uri = Uri.parse("http://kouuxd.wordpress.com/");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			Giris.this.startActivity(intent);
		}

	}

}
