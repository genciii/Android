package com.example.koukrokiand;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity  {
Button btndialog_activity;
Button btnkou_activity;


@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
requestWindowFeature(Window.FEATURE_NO_TITLE);
setTheme(android.R.style.Theme_Black_NoTitleBar_Fullscreen);
setContentView(R.layout.activity_main);

btnkou_activity=(Button)findViewById(R.id.button2);
btnkou_activity.setOnClickListener(new OnClickListener() {

@Override
public void onClick(View v) {
// TODO Auto-generated method stub
	   Uri uri = Uri.parse("http://www.kocaeli.edu.tr");
       Intent intent = new Intent(Intent.ACTION_VIEW, uri);
       startActivity(intent);
}
});


btndialog_activity=(Button)findViewById(R.id.button1);
btndialog_activity.setOnClickListener(new OnClickListener() {

@Override
public void onClick(View v) {
// TODO Auto-generated method stub
Intent intent=new Intent(getApplicationContext(), AndroidXMLParsingActivity.class);
startActivity(intent);
}
});
}
}