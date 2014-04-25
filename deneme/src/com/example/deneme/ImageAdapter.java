package com.example.deneme;

import java.io.InputStream;
import java.net.URL;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class ImageAdapter extends BaseAdapter implements ListAdapter {
	

	private Context context;

	public ImageAdapter(Context context) {
		super();
		this.context = context;

		GridViewConfig.addImageUrls();
	}

	public int getCount() {
		return GridViewConfig.getResim_list().size();

	}

	public Object getItem(int position) {

		return GridViewConfig.getResim_list().get(position);
	}

	public long getItemId(int position) {

		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(context);
			imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(5, 5, 5, 5);
		} else {
			imageView = (ImageView) convertView;

		}
		imageView.setImageDrawable(LoadImageFromURL(GridViewConfig
				.getResim_list().get(position)));
		return imageView;
	}

	private Drawable LoadImageFromURL(String url)

	{
		try {
			InputStream is = (InputStream) new URL(url).getContent();
			Drawable d = Drawable.createFromStream(is, "src");
			return d;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
