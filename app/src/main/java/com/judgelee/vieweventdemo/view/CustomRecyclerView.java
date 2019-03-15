package com.judgelee.vieweventdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.judgelee.vieweventdemo.utils.EventUtils;
import com.judgelee.vieweventdemo.utils.LogUtils;

/**
 * Author: lijiajie
 * Date: 2019/2/26
 * Desc:
 */
public class CustomRecyclerView extends RecyclerView {

  private float lastX;
  private float lastY;

  public CustomRecyclerView(@NonNull Context context) {
    super(context);
  }

  public CustomRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {

    switch (ev.getAction()) {
      case MotionEvent.ACTION_DOWN:
        getParent().requestDisallowInterceptTouchEvent(true);
        break;
      case MotionEvent.ACTION_MOVE:
        if (ev.getY() < lastY && !canScrollVertically(1)) {
          getParent().requestDisallowInterceptTouchEvent(false);
        } else if (ev.getY() > lastY && !canScrollVertically(-1)) {
          getParent().requestDisallowInterceptTouchEvent(false);
        } else {
          getParent().requestDisallowInterceptTouchEvent(true);
        }
        break;
      default:
        break;
    }
    lastX = ev.getX();
    lastY = ev.getY();

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
