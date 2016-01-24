package com.gaolei.slidingmenu;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.gaolei.slidingmenu.MyInterface.FinishActivityListener;

/**
 * 自定义RelativeLayout 拦截ListView监听事件
 */
public class CustomRelativeLayout extends RelativeLayout {

    private FinishActivityListener finishActivityListener;
    private int downX;

    public void setFinishActivityListener(FinishActivityListener finishActivityListener) {
        this.finishActivityListener = finishActivityListener;
    }

    public CustomRelativeLayout(Context context) {
        super(context);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
//onTouchEvent()是获取不到手势事件的，因为被ListView消耗了；只有在这判断手势监听事件 ，才能提前ListView获得
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        //说明将onTouch拦截在此控件，进而执行此控件的onTouchEvent
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX = (int) event.getRawX();
                Log.d("gaolei", "moveX-----------------" + moveX);
                Log.d("gaolei", "downX-----------------" + downX);
                //这里是判断最小滑动5，然后滑动边缘0~50彩触发销毁Activity，滑动屏幕中间不销毁
                if (moveX - downX > 5 && downX < 50) {
                	
                    finishActivityListener.onFinishActivity();
                }
                break;
        }
        return super.onInterceptTouchEvent(event);
    }
}
