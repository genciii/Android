package iticu.andro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Akademik extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout2);
        
      
        Button btn_fakulte = (Button) findViewById(R.id.btn_fakulte);
        
       
        Button btn_akademiktak = (Button) findViewById(R.id.btn_akademiktak);
        
       
        Button btn_myo = (Button) findViewById(R.id.btn_myo);
        
     
        Button btn_dersprog = (Button) findViewById(R.id.btn_dersprog);
        
        Button btn_entitu = (Button) findViewById(R.id.btn_entitu);
        
        Button btn_hazirkik = (Button) findViewById(R.id.btn_hazirlik);
        

        
      
 
        btn_fakulte.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Fakulteler.class);
				startActivity(i);
			}
		});
        
      
        btn_myo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Pdfdenemesi.class);
				startActivity(i);
			}
		});
        
      
        btn_akademiktak.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Akademiktak.class);
				startActivity(i);
			}
		});
        
     
        btn_dersprog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Dersprogrami.class);
				startActivity(i);
			}
		});
        
btn_entitu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Enstituler.class);
				startActivity(i);
			}
		});
        

btn_hazirkik.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View view) {
	
		Intent i = new Intent(getApplicationContext(), Hazirlik.class);
		startActivity(i);
	}
});


	
    }
}