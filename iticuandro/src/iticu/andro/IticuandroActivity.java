package iticu.andro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import android.widget.TextView;
import android.widget.LinearLayout;

public class IticuandroActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
        
 
        Button btn_uni = (Button) findViewById(R.id.btn_uni);
        
      
        Button btn_akademik = (Button) findViewById(R.id.btn_akademik);
       
        Button btn_duyurular = (Button) findViewById(R.id.btn_duyurular);
     
        Button btn_iletisim = (Button) findViewById(R.id.btn_iletisim);
        
        Button btn_sosyalarena = (Button) findViewById(R.id.sosyal);


        btn_duyurular.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
		
				Intent i = new Intent(getApplicationContext(), Duyurular.class);
				startActivity(i);
			}
		});
        
     
        btn_uni.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Universite.class);
				startActivity(i);
			}
		});
        
      
        btn_akademik.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Akademik.class);
				startActivity(i);
			}
		});
        
        btn_iletisim.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(), Iletisim.class);
				startActivity(i);
			}
		});
        
        btn_sosyalarena.setOnClickListener(new View.OnClickListener() {
			
     			@Override
     			public void onClick(View view) {
     		
     				Intent i = new Intent(getApplicationContext(), Sosyalarena.class);
     				startActivity(i);
     			}
     		});
        

	
    }
}