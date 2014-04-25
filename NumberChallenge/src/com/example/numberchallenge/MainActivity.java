package com.example.numberchallenge;

import java.util.Random;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener   {
	@Override
	public void onBackPressed() {
	    // do nothing.
	}
	private Button StartGame;
	private Button Options;
	private Button Facebook;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);	// Removes title bar
      	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);	// Removes notification bar
        
		setContentView(R.layout.activity_main);
		StartGame = (Button) findViewById(R.id.buttonStart);
		Options = (Button) findViewById(R.id.buttonOptions);
		Facebook = (Button) findViewById(R.id.buttonFaceBook);
		StartGame.setOnClickListener(this);
		Options.setOnClickListener(this);
		Facebook.setOnClickListener(this);
		
		
		
	}
	
	@Override
	public void onClick(View v) {
		
		// Check which button was clicked
		if (StartGame.isPressed()) {
		
				Random rnd = new Random();
				int x=rnd.nextInt(6)+1;
				         Intent intent = new Intent();
				switch(x){
				 case 1:
				  intent.setClass(this,GameActivity.class);
				  break;
				 case 2:
				  intent.setClass(this,GameActivity2.class);
				  break;
				 case 3:
				  intent.setClass(this,GameActivity3.class);
				  break;
				 case 4:
					  intent.setClass(this,GameActivity4.class);
					  break;
				 case 5:
					  intent.setClass(this,GameActivity5.class);
					  break;
				 case 6:
					  intent.setClass(this,GameActivity6.class);
					  break;
				 case 7:
					  intent.setClass(this,GameActivity7.class);
					  break;
				 }
				 startActivity(intent);        
				
	        
		}
		else if (Options.isPressed()) {
			Intent i = new Intent(MainActivity.this, Options.class);
			MainActivity.this.startActivity(i);
	        
		} 
		else if(Facebook.isPressed()){
			 Uri uri = Uri.parse("https://www.facebook.com/LogicChallenge");
	            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	            this.startActivity(intent);
		}

		
	}
	
	
		
	
}
