package com.judgelee.vieweventdemo.utils;

import android.util.Log;

/**
 * Author: lijiajie
 * Date: 2019/2/21
 * Desc:
 */
public class LogUtils {

  public static final String TAG = "ViewEventDemo";

  public static void v(String msg){
    Log.v(TAG, msg);
  }
  public static void d(String msg){
    Log.d(TAG, msg);
  }

  public static void d(String tag, String msg){
    Log.d(tag, msg);
  }

  public static void i(String msg){
    Log.i(TAG, msg);
  }
  public static void w(String msg){
    Log.w(TAG, msg);
  }

  public static void e(String msg){
    Log.e(TAG, msg);
  }

}
