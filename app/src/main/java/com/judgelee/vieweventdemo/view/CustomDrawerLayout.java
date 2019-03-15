package com.judgelee.vieweventdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import com.judgelee.vieweventdemo.utils.EventUtils;
import com.judgelee.vieweventdemo.utils.LogUtils;

/**
 * Author: lijiajie
 * Date: 2019/2/28
 * Desc:
 */
public class CustomDrawerLayout extends DrawerLayout {

  public CustomDrawerLayout(@NonNull Context context) {
    super(context);
  }

  public CustomDrawerLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
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
