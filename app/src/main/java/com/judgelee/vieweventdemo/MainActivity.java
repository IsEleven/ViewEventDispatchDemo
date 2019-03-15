package com.judgelee.vieweventdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.judgelee.vieweventdemo.view.CustomTextView;

public class MainActivity extends AppCompatActivity {

  private CustomTextView mTvTestFocus;
  private EditText mEtTestFocus;
  private LinearLayout mLLContainer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mLLContainer = findViewById(R.id.ll_container);
    mTvTestFocus = findViewById(R.id.tv_test_focus);
    mEtTestFocus = findViewById(R.id.et_test_focus);
  }

  public void onClickDetach(View view) {
    ListViewDetachActivity.start(this);
  }

  public void onClickEventDispatch(View view) {
    DispatchEventActivity.start(this);
  }

  public void onClickToast(View view) {
    Toast.makeText(this, "xxxx", Toast.LENGTH_SHORT).show();
  }

  public void onClickOverlapView(View view) {
    OverlapViewActivity.start(this);
  }

  public void onClickNestedRecyclerView(View view) {
    NestedRecyclerViewActivity.start(this);
  }

  public void onClickListClick(View view) {
    ListItemClickActivity.start(this);
  }

  public void onClickDrawerLayout(View view) {
    DrawerActivity.start(this);
  }
}
