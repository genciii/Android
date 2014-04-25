

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
 
public class Iletisim extends Activity {
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_layout);
        
        
        
        Button next = (Button) findViewById(R.id.btnTR);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Telefonrehber.class);
                startActivityForResult(myIntent, 0);
            }

        });
        
        
        
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        
        
        
        
 
        // Instance of ImageAdapter Class
        gridView.setAdapter(new Buyukresim(this));
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                    int position, long id) {
 
                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), Rehber.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }
}

