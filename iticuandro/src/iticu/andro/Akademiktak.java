package iticu.andro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Akademiktak extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        
      
        Button but1 = (Button) findViewById(R.id.bt1);
        Button but2 = (Button) findViewById(R.id.bt2);
        Button but3 = (Button) findViewById(R.id.bt3);
        

        but1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Akademikpdf.class);
				startActivity(i);
			}
		});
        
  but2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Akademikpdf2.class);
				startActivity(i);
			}
		});
  
  
  but3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View view) {
		
			Intent i = new Intent(getApplicationContext(), Akademikpdf3.class);
			startActivity(i);
		}
	});
    }
}