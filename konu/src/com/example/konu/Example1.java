package com.example.konu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Example1 extends Fragment {
	private Button button;
	private EditText text1, text2;
	private String name, name2, msg = null;
	private Button butto;

	/*@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_1);
		// if (button.isPressed()){
		// setContentView(R.layout.activity_1);
		// }
		// else if (button2.isPressed()){
		// setContentView(R.layout.activity_1_a);
		// }

		button = (Button) findViewById(R.id.button1);
		butto = (Button) findViewById(R.id.butto);
		text1 = (EditText) findViewById(R.id.editText2);
		text2 = (EditText) findViewById(R.id.editText1);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				for (int i = 0; i < 3; i++) {
					name = text1.getText().toString();
					text2.setText("Merhaba " + name + "\n");
					name2 = text2.getText().toString();
					msg += i + name2 + "\n";
					Toast.makeText(getApplicationContext(), msg,
							Toast.LENGTH_LONG).show();
				}
			}
		});

		butto.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});

	}*/
	Activity acty;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_1, container, false);

		
		button = (Button) rootView.findViewById(R.id.button1);
		butto = (Button) rootView.findViewById(R.id.butto);
		text1 = (EditText) rootView.findViewById(R.id.editText2);
		text2 = (EditText) rootView.findViewById(R.id.editText1);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				for (int i = 0; i < 3; i++) {
					name = text1.getText().toString();
					text2.setText("Merhaba " + name + "\n");
					name2 = text2.getText().toString();
					msg += i + name2 + "\n";
				//	Toast.makeText(acty, msg,
					//		Toast.LENGTH_LONG).show();
				}
			}
		});

		butto.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
			msg=null;
			text1.setText("");
			text2.setText("");
			}
		});
		return rootView;
	}
}