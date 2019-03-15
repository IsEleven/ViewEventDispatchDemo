package com.judgelee.vieweventdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.judgelee.vieweventdemo.utils.EventUtils;
import com.judgelee.vieweventdemo.utils.LogUtils;

/**
 * Author: lijiajie
 * Date: 2019/2/21
 * Desc:
 */
public class CustomTextView extends AppCompatTextView {

  public CustomTextView(Context context) {
    super(context);
  }

  public CustomTextView(Context context, @Nullable AttributeSet attrs) {
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
  public boolean onTouchEvent(MotionEvent event) {
    String action = EventUtils.getEventAction(event);
    LogUtils.d(this.getClass().getSimpleName() + " " + getText().toString() + ": onTouchEvent receive " + action);
    boolean consumed = super.onTouchEvent(event);
    LogUtils.d(this.getClass().getSimpleName() + " " + getText().toString() + ": onTouchEvent receive " + action + " " + consumed);
    return consumed;
    //return false;
  }

  @Override
  public void onStartTemporaryDetach() {
    LogUtils.d(this.getClass().getSimpleName() + " " + getText().toString()  + ": onStartTemporaryDetach");
    super.onStartTemporaryDetach();
  }

  @Override
  public void onFinishTemporaryDetach() {
    LogUtils.d(this.getClass().getSimpleName() + " " + getText().toString()  + ": onFinishTemporaryDetach");
    super.onFinishTemporaryDetach();
  }
}
