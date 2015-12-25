package com.gaolei.slidingmenu;

import com.example.zhy_slidingmenu.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class MainActivity extends Activity
{
	private SlidingMenu mMenu;
	public static RelativeLayout shadow_layout;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		mMenu = (SlidingMenu) findViewById(R.id.id_menu);
		 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
	           Window window = getWindow();
	            window.setFlags(
	                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
	                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
	            window.setBackgroundDrawableResource(R.color.contentTitleColor);
	        }
		 shadow_layout=(RelativeLayout)findViewById(R.id.shadow_layout);
	}

	public void toggleMenu(View view)
	{
		mMenu.toggle();
	}

}
