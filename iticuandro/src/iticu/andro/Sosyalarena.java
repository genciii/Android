package iticu.andro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sosyalarena extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sosyalpaylasim);
        
      
        Button button1 = (Button) findViewById(R.id.youtube);
        Button button2 = (Button) findViewById(R.id.facebook);
        Button button3 = (Button) findViewById(R.id.twitter);
        Button button4 = (Button) findViewById(R.id.iticu);
        

        button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Youtube.class);
				startActivity(i);
			}
		});
        
  button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Facebook.class);
				startActivity(i);
			}
		});
  
  
  button3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View view) {
		
			Intent i = new Intent(getApplicationContext(), Twitter.class);
			startActivity(i);
		}
	});
  
  
  button4.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View view) {
		
			Intent i = new Intent(getApplicationContext(), iticuweb.class);
			startActivity(i);
		}
	});
    }
}