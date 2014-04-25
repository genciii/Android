package com.example.deneme;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class Parse extends Activity {

    private GridView girGridView;


   @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_parse);


        girGridView=(GridView) findViewById(R.id.gridView1_bir);


        girGridView.setAdapter(new ImageAdapter(this));


        girGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()  {

       public void onItemClick(AdapterView<?> arg0, View view,                    int position,long arg3) {
  	    Toast.makeText(getApplicationContext(), GridViewConfig.getResim_list().
                 get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }
   

}
