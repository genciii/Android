package iticu.andro;




import java.io.File;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
 
public class Pdfdenemesi extends Activity {
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        Button next = (Button) findViewById(R.id.bt1);
        Button next1 = (Button) findViewById(R.id.bt2);
        Button next2 = (Button) findViewById(R.id.bt3);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Akademikpdf.class);
                startActivityForResult(myIntent, 0);
            }

        });
        next1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Akademikpdf2.class);
                startActivityForResult(myIntent, 0);
            }

        });
        
        next2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Akademikpdf3.class);
                startActivityForResult(myIntent, 0);
            }

        });
        
        
        
    }
}