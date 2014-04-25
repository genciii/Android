package com.example.numberchallenge;

import java.util.Random;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class GameActivity7 extends Activity implements OnClickListener   {
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ((keyCode == KeyEvent.KEYCODE_BACK)) {
	    	Intent intent=new Intent(getApplicationContext(), Sure.class);
			startActivity(intent);
	    }
	    return super.onKeyDown(keyCode, event);
	}

	private Button Answer1;
	private Button Answer2;
	private Button Answer3;
	private Button Answer4;
	private Button Answer5;
	private Button Answer6;
	private Button Answer7;
	private Button Answer8;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);	// Removes title bar
		setContentView(R.layout.activity_game_activity7);
		Answer1 = (Button) findViewById(R.id.ans1);
		Answer2 = (Button) findViewById(R.id.ans2);
		Answer3 = (Button) findViewById(R.id.ans3);
		Answer4 = (Button) findViewById(R.id.ans4);
		Answer5 = (Button) findViewById(R.id.ans5);
		Answer6 = (Button) findViewById(R.id.ans6);
		Answer7 = (Button) findViewById(R.id.ans7);
		Answer8 = (Button) findViewById(R.id.ans8);
		Answer1.setOnClickListener(this);
		Answer2.setOnClickListener(this);
		Answer3.setOnClickListener(this);
		Answer4.setOnClickListener(this);
		Answer5.setOnClickListener(this);
		Answer6.setOnClickListener(this);
		Answer7.setOnClickListener(this);
		Answer8.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		
		// Check which button was clicked
		if (Answer8.isPressed()) {
		
			 Toast.makeText(getApplicationContext(), "Thats all for now!!!", Toast.LENGTH_SHORT).show();
				 
		Intent intent=new Intent(getApplicationContext(), MainActivity.class);
				 startActivity(intent);        
				
	        
		}
		else {
			
			 Toast.makeText(getApplicationContext(), "WRONG!!!", Toast.LENGTH_SHORT).show();
			
		}

		
	}
		
	
}
