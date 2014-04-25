package iticu.andro;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;


	public class Akademikpdf extends Activity {
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
		    this.setContentView(iticu.andro.R.layout.webview_layout);  
		    this.myWebView = (WebView) this.findViewById(iticu.andro.R.id.webview);  
		    
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
		    myWebView.setVerticalScrollBarEnabled(true);
		    myWebView.getSettings().setUseWideViewPort(true);
		    myWebView.getSettings().setJavaScriptEnabled(true); 
		    myWebView.getSettings().setAllowFileAccess(true);
		    myWebView.getSettings().setPluginsEnabled(true);
			myWebView.loadUrl("https://docs.google.com/document/pub?id=1CS2RpS15X-i4jhG7bHl-KdRvNk_adaqdJvPv2TQdAvE");    
		    myWebView.getSettings().setUseWideViewPort(true);
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
	
	
	

