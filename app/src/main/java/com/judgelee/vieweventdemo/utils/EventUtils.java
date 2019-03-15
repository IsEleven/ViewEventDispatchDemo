package com.judgelee.vieweventdemo.utils;

import android.view.MotionEvent;

/**
 * Author: lijiajie
 * Date: 2019/2/21
 * Desc:
 */
public class EventUtils {

  public static String getEventAction(MotionEvent event){
    String msg = String.valueOf(event.getAction());
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        msg = "action_down";
        break;
      case MotionEvent.ACTION_MOVE:
        msg = "action_move";
        break;
      case MotionEvent.ACTION_UP:
        msg = "action_up";
        break;
      case MotionEvent.ACTION_CANCEL:
        msg = "action_cancel";
        break;
      default:
        break;
    }
    return msg;
  }

}
