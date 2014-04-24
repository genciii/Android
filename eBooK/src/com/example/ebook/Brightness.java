package com.example.ebook;



import android.app.Activity;
import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Brightness extends Activity {
	private SeekBar brightbar;
	private int brightness;
	private ContentResolver cResolver;
	private Window window;
	private Button done;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); // Removes title bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); // Removes
																// notification
																// bar
		setContentView(R.layout.activity_brightness);

		brightbar = (SeekBar) findViewById(R.id.brightbar);

		cResolver = getContentResolver();

		window = getWindow();

		brightbar.setMax(255);

		brightbar.setKeyProgressIncrement(1);
		
		done =(Button)findViewById(R.id.butClose);
		done.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			finish();
			}
			});
		
		

		try {

			brightness = System.getInt(cResolver, System.SCREEN_BRIGHTNESS);
		} catch (SettingNotFoundException e) {

			Log.e("Error", "Cannot access system brightness");
			e.printStackTrace();
		}

		brightbar.setProgress(brightness);

		brightbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			public void onStopTrackingTouch(SeekBar seekBar) {

				System.putInt(cResolver, System.SCREEN_BRIGHTNESS, brightness);

				LayoutParams layoutpars = window.getAttributes();

				layoutpars.screenBrightness = brightness / (float) 255;

				window.setAttributes(layoutpars);
			}

			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

				if (progress <= 10) {

					brightness = 10;
				} else {

					brightness = progress;
				}
			}
		});
	}
	
	
	}


