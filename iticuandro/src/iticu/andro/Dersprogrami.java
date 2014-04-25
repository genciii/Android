package iticu.andro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dersprogrami extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dersprogramlari);
        
      
        Button bt1 = (Button) findViewById(R.id.btu1);
        Button bt2 = (Button) findViewById(R.id.btu2);
        Button bt3 = (Button) findViewById(R.id.btu3);
        Button bt4 = (Button) findViewById(R.id.btu4);
        

        bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Dersprog.class);
				startActivity(i);
			}
		});
        
  bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Dersprog2.class);
				startActivity(i);
			}
		});
  
  
  bt3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View view) {
		
			Intent i = new Intent(getApplicationContext(), Dersprog3.class);
			startActivity(i);
		}
	});
  
  bt4.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View view) {
		
			Intent i = new Intent(getApplicationContext(), Dersprog4.class);
			startActivity(i);
		}
	});
    }
}