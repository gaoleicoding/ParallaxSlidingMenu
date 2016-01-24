package com.noter;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageView;
import com.noter.layout.SlideLayout;

public class MainActivity extends Activity implements OnClickListener{
	private static String TAG = "gaolei";
	private View mMenu;
	private int mMenuWidth;
	
	private SlideLayout mSlideLayout;
	private ImageView mMenuButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		mMenu = (View) findViewById(R.id.menu);
		mSlideLayout = (SlideLayout) findViewById(R.id.slide_layout);
		
		ViewTreeObserver vto = mMenu.getViewTreeObserver();
		vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() { 
			@Override
			public void onGlobalLayout() {
				mMenuWidth = mMenu.getWidth();
				mSlideLayout.setMaxScrollX(mMenuWidth);
				Log.v(TAG, "Max Scroll Distance: " + mMenuWidth);
			}
		});
		
		mMenuButton = (ImageView) findViewById(R.id.menuButton);
		mMenuButton.setOnClickListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.v(TAG, "Main Touch Here");
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.menuButton: {
			if(mSlideLayout.isMenuOpen()) {
				SlideLayout.clickMenuToClose=true;
				mSlideLayout.closeMenu();
				
			} else {
				SlideLayout.clickMenuToClose=false;
				mSlideLayout.openMenu();
			}
			break;
		}
		default:
			break;
		}
	}
}
