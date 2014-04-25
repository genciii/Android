package com.example.ebook;  
  
import java.io.File;  
import java.util.ArrayList;  
import java.util.List;  
  
import android.app.ListActivity;  
import android.os.Bundle;  
import android.widget.ArrayAdapter;  
  
public class ListOk extends ListActivity  
{  
  
    public void onCreate(Bundle savedInstanceState)  
    {  
        super.onCreate(savedInstanceState);  
  
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  
                android.R.layout.simple_list_item_1,  
                FileToStr(TestActivty.txtList));  
        setListAdapter(adapter);  
    }  
  
    /** 
     *  
     *  
     * @param f 
     * @return 
     */  
    public String[] FileToStr(List<File> f)  
    {  
        ArrayList<String> listStr = new ArrayList<String>();  
        for (int i = 0; i < f.size(); i++)  
        {  
            String nameString = f.get(i).getName();  
            listStr.add(nameString);  
        }  
        return listStr.toArray(new String[0]);  
    }  
}  