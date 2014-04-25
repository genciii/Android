package com.example.eokuu;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ayarlar extends Activity {

	Button btnDisplaySetting;
	Intent intentDisplaySetting;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ayarlar);
		btnDisplaySetting = (Button) findViewById(R.id.Ayarlar);

		intentDisplaySetting = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
		ResolveInfo resolveInfo = getPackageManager().resolveActivity(
				intentDisplaySetting, 0);

		if (resolveInfo == null) {
			Toast.makeText(Ayarlar.this, "Not Support!", Toast.LENGTH_LONG)
					.show();
			btnDisplaySetting.setEnabled(false);
		} else {
			btnDisplaySetting.setEnabled(true);
		}

		btnDisplaySetting.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(intentDisplaySetting);
			}
		});
	}
}