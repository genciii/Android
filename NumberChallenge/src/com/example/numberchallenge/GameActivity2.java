package com.example.numberchallenge;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class GameActivity2 extends Activity {
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
	    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);	// Removes title bar
	        setContentView(R.layout.activity_game_activity2);
	        ed_txt=(EditText)findViewById(R.id.phone);
	 
	        ed_txt.addTextChangedListener(new TextWatcher() {
	            public void afterTextChanged(Editable s) {
	                if(ed_txt.getText().toString().trim().length() > 0){
	                    if(Integer.parseInt(ed_txt.getText().toString().trim()) < 1598 && Integer.parseInt(ed_txt.getText().toString().trim()) > 1596){
	                    	Intent intent=new Intent(getApplicationContext(), NextLevel2.class);
	                    	startActivity(intent);
	                    	ed_txt.setTextColor(Color.GREEN);
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
	    
	    
	}