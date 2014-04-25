package com.example.numberchallenge;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class NextLevel extends Activity {
	Button NextLevel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setProgressBarIndeterminateVisibility(false);
		setContentView(R.layout.activity_next_level);
		NextLevel=(Button)findViewById(R.id.buttonNext);
		NextLevel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(getApplicationContext(), GameActivity2.class);
			startActivity(intent);
			finish();
			}
			});

	}


}
