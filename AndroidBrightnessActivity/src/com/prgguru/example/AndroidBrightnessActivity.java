package com.prgguru.example;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class AndroidBrightnessActivity extends Activity {//UI objects//
	//Seek bar object
	private SeekBar brightbar;

	//Variable to store brightness value
	private int brightness;
	//Content resolver used as a handle to the system's settings
	private ContentResolver cResolver;
	//Window object, that will store a reference to the current window
	private Window window;
	
	TextView txtPerc;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Instantiate seekbar object
        brightbar = (SeekBar) findViewById(R.id.brightbar);
        
        txtPerc = (TextView) findViewById(R.id.txtPercentage);
        
        //Get the content resolver
        cResolver = getContentResolver();
        
        //Get the current window
        window = getWindow();
        
        //Set the seekbar range between 0 and 255
        brightbar.setMax(255);
        //Set the seek bar progress to 1
        brightbar.setKeyProgressIncrement(1);
      
        try 
        {
        	//Get the current system brightness
        	brightness = System.getInt(cResolver, System.SCREEN_BRIGHTNESS);
		} 
        catch (SettingNotFoundException e) 
		{
        	//Throw an error case it couldn't be retrieved
			Log.e("Error", "Cannot access system brightness");
			e.printStackTrace();
		}
		
		//Set the progress of the seek bar based on the system's brightness
		brightbar.setProgress(brightness);

		//Register OnSeekBarChangeListener, so it can actually change values
		brightbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			public void onStopTrackingTouch(SeekBar seekBar) 
			{
				//Set the system brightness using the brightness variable value
				System.putInt(cResolver, System.SCREEN_BRIGHTNESS, brightness);
				//Get the current window attributes
				LayoutParams layoutpars = window.getAttributes();
				//Set the brightness of this window
				layoutpars.screenBrightness = brightness / (float)255;
				//Apply attribute changes to this window
				window.setAttributes(layoutpars);
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) 
			{
				//Nothing handled here
			}
			
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
			{
				//Set the minimal brightness level
				//if seek bar is 20 or any value below
				if(progress<=20)
				{
					//Set the brightness to 20
					brightness=20;
				}
				else //brightness is greater than 20
				{
					//Set brightness variable based on the progress bar 
					brightness = progress;
				}
				//Calculate the brightness percentage
				float perc = (brightness /(float)255)*100;
				//Set the brightness percentage 
				txtPerc.setText((int)perc +"%");
			}
		});	
    }}
