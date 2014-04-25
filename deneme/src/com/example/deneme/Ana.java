package com.example.deneme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Ana extends Activity implements OnClickListener {

	private Button Parlaklik;
	private Button ImageParse;
	private Button ParsingGrid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); // Removes title bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); // Removes
																// notification
																// bar
		setContentView(R.layout.activity_ana);
		Parlaklik = (Button) findViewById(R.id.Par);
		Parlaklik.setOnClickListener(this);
		ImageParse = (Button) findViewById(R.id.Parse);
		ImageParse.setOnClickListener(this);
		ParsingGrid = (Button) findViewById(R.id.Parsing);
		ParsingGrid.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		if (Parlaklik.isPressed()) {
			Intent i = new Intent(Ana.this, MainActivity.class);
			Ana.this.startActivity(i);

		}
		else if (ImageParse.isPressed()){
			Intent o = new Intent (Ana.this, Parse.class);
			Ana.this.startActivity(o);
		}
		else if (ParsingGrid.isPressed()){
			Intent i = new Intent (Ana.this,AndroidXMLParsingActivity.class);
			Ana.this.startActivity(i);
		}

	}

}
