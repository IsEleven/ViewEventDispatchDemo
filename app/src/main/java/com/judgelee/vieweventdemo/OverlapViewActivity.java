package com.judgelee.vieweventdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.judgelee.vieweventdemo.utils.LogUtils;

/**
 * Author: lijiajie
 * Date: 2019/2/22
 * Desc: 重叠View点击事件的处理顺序是从最上层（addView的逆序）View开始处理的，找到处理的View直接退出循环
 */
public class OverlapViewActivity extends AppCompatActivity {

  public static void start(Activity activity) {
    Intent intent = new Intent(activity, OverlapViewActivity.class);
    activity.startActivity(intent);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_overlap);
  }

  public void onClickBtn1(View view) {
    LogUtils.d(view.getClass().getSimpleName() + " " + ((Button) view).getText() + " onClick ");
    Toast.makeText(this, "button1 click", Toast.LENGTH_SHORT).show();
  }

  public void onClickBtn2(View view) {
    LogUtils.d(view.getClass().getSimpleName() + " " + ((Button) view).getText() + " onClick ");
    Toast.makeText(this, "button2 click", Toast.LENGTH_SHORT).show();
  }
}
