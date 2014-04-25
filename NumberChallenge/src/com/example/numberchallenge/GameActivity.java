package com.example.numberchallenge;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GameActivity extends Activity {
	static final String STATE_SCORE = "GameActivity";
	private Button Save;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ((keyCode == KeyEvent.KEYCODE_BACK)) {
	    	Intent intent=new Intent(getApplicationContext(), Sure.class);
			startActivity(intent);
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	  private EditText ed_txt;
	  
	  
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_game);
	       
	    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);	// Removes title bar
	        
	        ed_txt=(EditText)findViewById(R.id.phone);
	 
	        ed_txt.addTextChangedListener(new TextWatcher() {
	            public void afterTextChanged(Editable s) {
	                if(ed_txt.getText().toString().trim().length() > 0){
	                    if(Integer.parseInt(ed_txt.getText().toString().trim()) < 12 && Integer.parseInt(ed_txt.getText().toString().trim()) > 10){
	                    	ed_txt.setTextColor(Color.GREEN);
	                    	Intent intent=new Intent(getApplicationContext(), NextLevel.class);
	                    	startActivity(intent);
	                    }else{
	                        Toast.makeText(getApplicationContext(), "Wrong!!!", Toast.LENGTH_SHORT).show();
	                        ed_txt.setTextColor(Color.RED);
	                    }
	                }
	            }
	 
	            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
	            public void onTextChanged(CharSequence s, int start, int before, int count) {
	            }
	        });
	    }
	    
	
  				
  				@Override
  				public void onSaveInstanceState(Bundle savedInstanceState) {
  				    // Save the user's current game state
  				//    savedInstanceState.putInt(STATE_SCORE, app_na);
  				    
  				    // Always call the superclass so it can save the view hierarchy state
  				    super.onSaveInstanceState(savedInstanceState);
  				}
  			
  			
	  	
	  
	}