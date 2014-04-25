
	package iticu.andro;



import java.lang.reflect.Method;

import android.app.Activity;
	import android.content.Intent;
import android.net.Uri;
	import android.os.Bundle;
	import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
	import android.widget.Button;
	import android.content.Context;
	import android.content.res.ColorStateList;
	import android.content.res.Resources;
	import android.graphics.Bitmap;
	import android.graphics.BitmapFactory;
	import android.graphics.Canvas;
	import android.graphics.Paint;
	import android.graphics.RectF;
	import android.graphics.drawable.Drawable;
	import android.os.Bundle;
	import android.os.Handler;
	import android.os.Message;
	import android.util.AttributeSet;
import android.view.Gravity;
	import android.view.KeyEvent;
import android.view.MotionEvent;
	import android.view.SurfaceHolder;
	import android.view.SurfaceView;
	import android.view.View;
import android.view.ViewGroup;
	import android.widget.TextView;
	import android.app.Activity;
	import android.graphics.BitmapFactory;
	import android.os.Bundle;
	import android.widget.*;
	import android.app.Activity;
	import android.content.Intent;
	import android.os.Bundle;
import android.view.View;




public class Telefonrehber extends Activity {
	final Activity activity = this;
	  private WebView myWebView;  
	  private static final FrameLayout.LayoutParams ZOOM_PARAMS =  
	new FrameLayout.LayoutParams(  
	ViewGroup.LayoutParams.FILL_PARENT,  
	ViewGroup.LayoutParams.WRAP_CONTENT,  
	Gravity.BOTTOM);  
	 
	  
	  @Override  
	  protected void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
	    this.setContentView(R.layout.webview_layout);  
	    this.myWebView = (WebView) this.findViewById(R.id.webview);  
	   
	    
	    myWebView.setWebChromeClient(new WebChromeClient() {
	    
            public void onProgressChanged(WebView view, int progress)
            {
                activity.setTitle("Loading...Please Wait...");
                activity.setProgress(progress * 100);
 
                if(progress == 100)
                    activity.setTitle(R.string.app_name);
            }
        });
	    
	    
	    FrameLayout mContentView = (FrameLayout) getWindow().  
	    getDecorView().findViewById(android.R.id.content);  
	    final View zoom = this.myWebView.getZoomControls();  
	    mContentView.addView(zoom, ZOOM_PARAMS);  
	    zoom.setVisibility(View.GONE);  
	
	    this.myWebView.loadUrl("http://www.iticu.edu.tr/pages/tel-akademik.aspx");  
	    myWebView.getSettings().setUseWideViewPort(true);
	    myWebView.setVerticalScrollBarEnabled(true);
	    myWebView.getSettings().setUseWideViewPort(true);
	    myWebView.getSettings().setJavaScriptEnabled(true);
	
	    myWebView.requestFocus(View.FOCUS_DOWN);
	    myWebView.setOnTouchListener(new View.OnTouchListener() {
	        @Override
	        public boolean onTouch(View v, MotionEvent event) {
	            switch (event.getAction()) {
	                case MotionEvent.ACTION_DOWN:
	                case MotionEvent.ACTION_UP:
	                    if (!v.hasFocus()) {
	                        v.requestFocus();
	                    }
	                    break;
	            }
	            return false;
	        }
	    });
		  
	  }  
	}  
	
	

	

