package com.judgelee.vieweventdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.judgelee.vieweventdemo.utils.EventUtils;
import com.judgelee.vieweventdemo.utils.LogUtils;

/**
 * Author: lijiajie
 * Date: 2019/2/28
 * Desc:
 */
public class CustomRelativeLayout extends RelativeLayout {

  public CustomRelativeLayout(Context context) {
    super(context);
  }

  public CustomRelativeLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    String action = EventUtils.getEventAction(ev);
    LogUtils.d(this.getClass().getSimpleName() + ": dispatchTouchEvent  " + action);
    boolean consumed = super.dispatchTouchEvent(ev);
    LogUtils.d(this.getClass().getSimpleName() + ": dispatchTouchEvent  " + action + " " + consumed);
    return consumed;
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent ev) {
    String action = EventUtils.getEventAction(ev);
    LogUtils.d(this.getClass().getSimpleName() + ": onInterceptTouchEvent  " + action);
    boolean intercepted = super.onInterceptTouchEvent(ev);
    LogUtils.d(this.getClass().getSimpleName() + ": onInterceptTouchEvent  " + action + " " + intercepted);
    return intercepted;
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    String action = EventUtils.getEventAction(event);
    LogUtils.d(this.getClass().getSimpleName() + ": onTouchEvent receive " + action);
    boolean consumed = super.onTouchEvent(event);
    LogUtils.d(this.getClass().getSimpleName() + ": onTouchEvent receive " + action + " " + consumed);
    return consumed;
  }
}
