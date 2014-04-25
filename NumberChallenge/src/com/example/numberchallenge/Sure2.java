package com.example.numberchallenge;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class Sure2 extends Activity {
	Button Yes;
	Button No;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setProgressBarIndeterminateVisibility(false);
		setContentView(R.layout.activity_sure);
		Yes=(Button)findViewById(R.id.buttonYes);
		Yes.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
		   android.os.Process.killProcess(android.os.Process.myPid());
			}
			});

	No=(Button)findViewById(R.id.buttonNo);
	No.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
		finish();
		}
		});
	}
}

	
