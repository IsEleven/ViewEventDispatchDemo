package com.judgelee.vieweventdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.judgelee.vieweventdemo.utils.EventUtils;
import com.judgelee.vieweventdemo.utils.LogUtils;

/**
 * Author: lijiajie
 * Date: 2019/2/21
 * Desc:
 */
public class CustomListView extends ListView {

  public static final String className = "CustomListView";

  public CustomListView(Context context) {
    super(context);
  }

  public CustomListView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    String action = EventUtils.getEventAction(ev);
    LogUtils.d(className + ": dispatchTouchEvent  " + action);
    boolean consumed = super.dispatchTouchEvent(ev);
    LogUtils.d(className + ": dispatchTouchEvent  " + action + " " + consumed);
    return consumed;
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent ev) {
    String action = EventUtils.getEventAction(ev);
    LogUtils.d(className + ": onInterceptTouchEvent  " + action);
    boolean intercepted = super.onInterceptTouchEvent(ev);
    LogUtils.d(className + ": onInterceptTouchEvent  " + action + " " + intercepted);
    return intercepted;
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    String action = EventUtils.getEventAction(event);
    LogUtils.d(className + ": onTouchEvent receive " + action);
    boolean consumed = super.onTouchEvent(event);
    LogUtils.d(className + ": onTouchEvent receive " + action + " " + consumed);
    return consumed;
  }

  @Override
  public void onStartTemporaryDetach() {
    LogUtils.d(className + ": onStartTemporaryDetach ");
    super.onStartTemporaryDetach();
  }

  @Override
  public void onFinishTemporaryDetach() {
    LogUtils.d(className + ": onFinishTemporaryDetach");
    super.onFinishTemporaryDetach();
  }
}
