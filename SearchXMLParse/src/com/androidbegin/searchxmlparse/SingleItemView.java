package com.androidbegin.searchxmlparse;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends Activity implements OnClickListener {
	// Declare Variables
	Button indir;
	Button web;
	String rank;
	String country;
	String population;
	String flag;
	String position;
	ImageLoader imageLoader = new ImageLoader(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.singleitemview);

		Intent i = getIntent();
		// Get the result of rank
		rank = i.getStringExtra("rank");
		// Get the result of country
		country = i.getStringExtra("country");
		// Get the result of population
		population = i.getStringExtra("population");
		// Get the result of flag
		flag = i.getStringExtra("flag");

		// Locate the TextViews in singleitemview.xml
		TextView txtrank = (TextView) findViewById(R.id.rank);
		TextView txtcountry = (TextView) findViewById(R.id.country);
		TextView txtpopulation = (TextView) findViewById(R.id.population);
		web = (Button) findViewById(R.id.web);
		web.setOnClickListener(this);
		indir = (Button) findViewById(R.id.indir);
		indir.setOnClickListener(this);
		// Locate the ImageView in singleitemview.xml
		ImageView imgflag = (ImageView) findViewById(R.id.flag);

		// Set results to the TextViews
		txtrank.setText(rank);
		txtcountry.setText(country);
		txtpopulation.setText(population);

		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(flag, imgflag);
		
	}

	@Override
	public void onClick(View v) {
		if (web.isPressed()) {
			Uri uri = Uri.parse(flag);
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			SingleItemView.this.startActivity(intent);

		}
		else if (indir.isPressed()){
			Intent intent = new Intent (SingleItemView.this,Downloaded.class);
			Bundle bundle= getIntent().getExtras();
			if(bundle!=null){
				intent.putExtras(bundle);
				startActivity(intent);
			}
				
			
		}
	}
}