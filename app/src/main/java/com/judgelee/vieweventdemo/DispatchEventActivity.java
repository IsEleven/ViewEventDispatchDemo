package com.judgelee.vieweventdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.judgelee.vieweventdemo.utils.EventUtils;
import com.judgelee.vieweventdemo.utils.LogUtils;

/**
 * Author: lijiajie
 * Date: 2019/2/21
 * Desc:
 */
public class DispatchEventActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {

  public static void start(Activity activity) {
    Intent intent = new Intent(activity, DispatchEventActivity.class);
    activity.startActivity(intent);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_event_dispatch);
    LinearLayout containerLayout = findViewById(R.id.ll_container);
    Button testBtn = findViewById(R.id.btn_test);

    containerLayout.setOnTouchListener(this);
    testBtn.setOnTouchListener(this);

    containerLayout.setOnClickListener(this);
    testBtn.setFocusable(false);
    testBtn.setFocusableInTouchMode(false);
    testBtn.setOnClickListener(this);
    testBtn.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View v) {
        LogUtils.d(v.getClass().getSimpleName() + " onLongClick ");
        return true;
      }
    });
  }

  @Override
  public boolean onTouch(View v, MotionEvent event) {
    LogUtils.d(v.getClass().getSimpleName() + " onTouch : receive " + EventUtils.getEventAction(event) + " " + false);
    return false;
  }

  @Override
  public void onClick(View v) {
    LogUtils.d(v.getClass().getSimpleName() + " onClick ");
    switch (v.getId()) {
      case R.id.ll_container:
        Toast toast = Toast.makeText(this, "LinearLayout onClick", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        break;
      case R.id.btn_test:
        Toast.makeText(this, "Button onClick", Toast.LENGTH_SHORT).show();
        //((ViewGroup) v.getParent()).performClick();
        //((ViewGroup) v.getParent()).callOnClick();
        break;
    }
  }

  public void onClickToast(View view) {
    Toast.makeText(this, "toast test", Toast.LENGTH_SHORT).show();
  }
}
