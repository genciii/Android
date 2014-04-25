package com.example.eokuu;

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

/**
 * @author Gencay Deniz This is a AlertDialog Activity you can see in
 *         AndroidManifest.xml
 * 
 *         <activity android:name="com.example.eokuu.Brightness"
 *         android:label="@string/app_name"
 *         android:theme="@android:style/Theme.Dialog" > </activity>
 * 
 */

public class Brightness extends Activity {
	private SeekBar brightbar;
	private int brightness;
	private ContentResolver cResolver;
	private Window window;
	private Button done;
	float a = 255;

	/*
	 * @see android.app.Activity#onCreate(android.os.Bundle) We remove the title
	 * bar and notification bar... identifying the seekbar and other companents
	 * is also here
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_brightness);
		

		brightbar = (SeekBar) findViewById(R.id.brightbar);

		cResolver = getContentResolver();

		window = getWindow();

		brightbar.setMax(255);

		brightbar.setKeyProgressIncrement(1);

		done = (Button) findViewById(R.id.butClose);
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

				layoutpars.screenBrightness = brightness / a;

				window.setAttributes(layoutpars);
			}

			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * android.widget.SeekBar.OnSeekBarChangeListener#onProgressChanged
			 * (android.widget.SeekBar, int, boolean)
			 */
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

				if (progress <= 1) {

					brightness = 1;
				} else {

					brightness = progress;
				}
			}
		});
	}

}
