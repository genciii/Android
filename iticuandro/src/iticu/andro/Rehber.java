package iticu.andro;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
 
public class Rehber extends Activity {
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photos_layout);
        
    
 
        // get intent data
        Intent i = getIntent();
 
        // Selected image id
        int position = i.getExtras().getInt("id");
        Buyukresim imageAdapter = new Buyukresim(this);
 
        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);
        
    }
    
 
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menulayout, menu);
        return true;
    }
 
   
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
 
        switch (item.getItemId())
        {
        case R.id.MEK:
        	startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:02125114150" )));
        	
        	return true;
 
        case R.id.UK:
        	startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:02165539422" )));
        	return true;
        case R.id.KK:
        	startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:02164891888" )));
        	return true;
        case R.id.MYO:
        	startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:02164891888" )));
        	return true;
        case R.id.GPS:
            Toast.makeText(Rehber.this, "Bu Ozellik Daha Sonra Eklenicek!", Toast.LENGTH_SHORT).show();
            return true;
            
        case R.id.TR:
        	 Intent myIntent = new Intent(getApplicationContext(), Telefonrehber.class);
             startActivity(myIntent);
 
 
        default:
            return super.onOptionsItemSelected(item);
        }
  
        

}
}
    
