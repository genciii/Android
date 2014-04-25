package com.example.konu;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Button a, b, c, d, e, f, g, h, z, x, q, w, s;
	EditText t1, t2;
	String n1, n2;
	Date tarih;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		s = (Button) findViewById(R.id.s);
		a = (Button) findViewById(R.id.a);
		b = (Button) findViewById(R.id.b);
		c = (Button) findViewById(R.id.c);
		d = (Button) findViewById(R.id.d);
		e = (Button) findViewById(R.id.e);
		f = (Button) findViewById(R.id.f);
		g = (Button) findViewById(R.id.g);
		h = (Button) findViewById(R.id.h);
		z = (Button) findViewById(R.id.z);
		x = (Button) findViewById(R.id.x);
		q = (Button) findViewById(R.id.q);
		w = (Button) findViewById(R.id.w);
		s.setOnClickListener(this);
		a.setOnClickListener(this);
		b.setOnClickListener(this);
		c.setOnClickListener(this);
		d.setOnClickListener(this);
		e.setOnClickListener(this);
		f.setOnClickListener(this);
		g.setOnClickListener(this);
		h.setOnClickListener(this);
		z.setOnClickListener(this);
		x.setOnClickListener(this);
		q.setOnClickListener(this);
		w.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (s.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Telefonun saatinden yararlaniyorsunuz", Toast.LENGTH_LONG)
					.show();
			tarih = new Date();
			s.setText(tarih.toString());

		} else if (a.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Example1 Activitysini Seçtiniz", Toast.LENGTH_LONG).show();
			Intent i = new Intent(MainActivity.this, LayMainActivity.class);
			startActivity(i);
		} else if (b.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Example2 Activitysini Seçtiniz", Toast.LENGTH_LONG).show();
			Intent i = new Intent(MainActivity.this, LayMainActivity.class);
			startActivity(i);
		} else if (c.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Example3 Activitysini Seçtiniz", Toast.LENGTH_LONG).show();
			Intent i = new Intent(MainActivity.this, Example1.class);
			startActivity(i);
		} else if (d.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Example4 Activitysini Seçtiniz", Toast.LENGTH_LONG).show();
			Intent i = new Intent(MainActivity.this, Example1.class);
			startActivity(i);
		} else if (e.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Example5 Activitysini Seçtiniz", Toast.LENGTH_LONG).show();
			Intent i = new Intent(MainActivity.this, Example1.class);
			startActivity(i);
		} else if (f.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Example6 Activitysini Seçtiniz", Toast.LENGTH_LONG).show();
			Intent i = new Intent(MainActivity.this, Example1.class);
			startActivity(i);
		} else if (g.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Example7 Activitysini Seçtiniz", Toast.LENGTH_LONG).show();
			Intent i = new Intent(MainActivity.this, Example1.class);
			startActivity(i);
		} else if (h.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Example8 Activitysini Seçtiniz", Toast.LENGTH_LONG).show();
			Intent i = new Intent(MainActivity.this, Example1.class);
			startActivity(i);
		} else if (z.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Example9 Activitysini Seçtiniz", Toast.LENGTH_LONG).show();
			Intent i = new Intent(MainActivity.this, Example1.class);
			startActivity(i);
		} else if (x.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Example10 Activitysini Seçtiniz", Toast.LENGTH_LONG)
					.show();
			Intent i = new Intent(MainActivity.this, Example1.class);
			startActivity(i);
		} else if (q.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Example11 Activitysini Seçtiniz", Toast.LENGTH_LONG)
					.show();
			Intent i = new Intent(MainActivity.this, Example1.class);
			startActivity(i);
		} else if (w.isPressed()) {
			Toast.makeText(getApplicationContext(),
					"Example12 Activitysini Seçtiniz", Toast.LENGTH_LONG)
					.show();
			Intent i = new Intent(MainActivity.this, Example1.class);
			startActivity(i);
		}

	}

}