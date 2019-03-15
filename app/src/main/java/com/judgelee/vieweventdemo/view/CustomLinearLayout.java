package com.judgelee.vieweventdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.judgelee.vieweventdemo.utils.EventUtils;
import com.judgelee.vieweventdemo.utils.LogUtils;

/**
 * Author: lijiajie
 * Date: 2019/2/21
 * Desc:
 */
public class CustomLinearLayout extends LinearLayout {

  public CustomLinearLayout(Context context) {
    super(context);
  }

  public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    // 想要子View和Parent同时响应事件必须去重写dispatchTouchEvent
    // 第一种方式
    //super.onTouchEvent(ev);
    //onTouchEvent(ev);

    // 第二种方式
    // 在父容器的onClick方法里面去调用子View的onClick方法 onTouchEvent同理

    // 第三种方式（偏向）
    // 在子View的onClick方法中去调用父容器的onClick方法 onTouchEvent同理

    // 第四种方式（可用）
    // 在onIntercept中去响应点击事件

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
