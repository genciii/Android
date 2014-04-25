package iticu.andro;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
 
public class Buyukresim extends BaseAdapter {
    private Context mContext;
 
  
    public Integer[] mThumbIds = {
            R.drawable.iletisim1, R.drawable.iletisim2,
            R.drawable.iletisim3, R.drawable.iletisim4,
      
    };
 
    public Buyukresim(Context c){
        mContext = c;
    }
 
    @Override
    public int getCount() {
        return mThumbIds.length;
    }
 
    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }
 
    @Override
    public long getItemId(int position) {
        return 0;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_END);
        imageView.setLayoutParams(new GridView.LayoutParams(280, 280));
      
        return imageView;
    }
 
}


