package com.example.numbercounterwithbutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * Uses a TextSwitcher.
 */
public class MainActivity extends Activity implements ViewSwitcher.ViewFactory,
		View.OnClickListener {

	private TextSwitcher mSwitcher;

	private int mCounter = 0;
	Button nextButton;
	Button delButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSwitcher = (TextSwitcher) findViewById(R.id.switcher);
		mSwitcher.setFactory(this);
		Animation in = AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in);
		Animation out = AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out);
		mSwitcher.setInAnimation(in);
		mSwitcher.setOutAnimation(out);

		nextButton = (Button) findViewById(R.id.next);
		nextButton.setOnClickListener(this);
		delButton = (Button) findViewById(R.id.delete);
		delButton.setOnClickListener(this);
		updateCounter();
	}

	@Override
	public void onClick(View v) {
		if (nextButton.isPressed()) {
			mCounter++;

		} else if (delButton.isPressed()) {
			mCounter--;

		}
		updateCounter();
	}

	private void updateCounter() {
		mSwitcher.setText(String.valueOf(mCounter));
	}

	public View makeView() {
		TextView t = new TextView(this);
		t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
		t.setTextSize(36);
		return t;
	}
}
