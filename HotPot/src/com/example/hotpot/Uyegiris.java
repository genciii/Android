package com.example.hotpot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;

public class Uyegiris extends Activity {
	Button buttungir;
	Spinner spin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uyegiris);
		buttungir = (Button) findViewById(R.id.btnLogin);
		spin = (Spinner) findViewById(R.id.spinner1);

		addListenerOnSpinnerItemSelection();

	}

	public void addListenerOnSpinnerItemSelection() {

		spin.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {

				if (pos == 1) {
					buttungir.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {

							Intent i = new Intent(Uyegiris.this,
									MainActivitySatici.class);
							startActivity(i);

						}

					});

				} else if (pos == 0) {
					buttungir.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {

							Intent i = new Intent(Uyegiris.this,
									MainActivityUye.class);
							startActivity(i);

						}

					});

				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}

		});
	}

}
