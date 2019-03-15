package com.judgelee.vieweventdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatButton;
import com.judgelee.vieweventdemo.utils.EventUtils;
import com.judgelee.vieweventdemo.utils.LogUtils;

/**
 * Author: lijiajie
 * Date: 2019/2/21
 * Desc:
 */
public class CustomButton extends AppCompatButton {

  public CustomButton(Context context) {
    super(context);
  }

  public CustomButton(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    String action = EventUtils.getEventAction(ev);
    LogUtils.d(this.getClass().getSimpleName() + " " + getText().toString() + ": dispatchTouchEvent  " + action);
    boolean consumed = super.dispatchTouchEvent(ev);
    LogUtils.d(this.getClass().getSimpleName() + " " + getText().toString() + ": dispatchTouchEvent  " + action + " " + consumed);
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
}
