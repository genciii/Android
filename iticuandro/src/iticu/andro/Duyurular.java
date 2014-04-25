package iticu.andro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class Duyurular extends Activity {
	TextView httpStuff;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpex);
		httpStuff = (TextView) findViewById(R.id.tvHttp);
		TestHttpGet test = new TestHttpGet();
		String returned;
		
		try {
			returned = test.getInternetData();
			httpStuff.setText(returned);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
