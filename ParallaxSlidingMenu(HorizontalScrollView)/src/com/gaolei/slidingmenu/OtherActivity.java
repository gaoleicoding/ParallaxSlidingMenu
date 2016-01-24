package com.gaolei.slidingmenu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.zhy_slidingmenu.R;
import com.gaolei.slidingmenu.MyInterface.FinishActivityListener;

public class OtherActivity extends Activity implements FinishActivityListener{

	private ListView wxmessage_listview;
	private List<String> messageList = new ArrayList<String>();
	private CustomRelativeLayout parent_layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.message_activity);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			Window window = getWindow();
			window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.setBackgroundDrawableResource(R.color.contentTitleColor);
		}
		for (int i = 0; i < 20; i++) {
			messageList.add("MESSAGE-" + i);
		}
		parent_layout = (CustomRelativeLayout) findViewById(R.id.parent_layout);
		wxmessage_listview = (ListView) findViewById(R.id.wxmessage_listview);
		parent_layout.setFinishActivityListener(this);
		WXMessageAdapter adapter = new WXMessageAdapter(messageList, this);
		wxmessage_listview.setAdapter(adapter);
	}
//接口回调  监听手势滑动销毁Activity
	@Override
	public void onFinishActivity() {
		// TODO Auto-generated method stub
		finish();
	}
	public void finishActivity(View view) {
		// TODO Auto-generated method stub
		finish();
	}


}
