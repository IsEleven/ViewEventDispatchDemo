package com.judgelee.vieweventdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: lijiajie
 * Date: 2019/2/20
 * Desc: 测试onStartTemporaryDetach方法的调用时机
 */
public class ListViewDetachActivity extends AppCompatActivity {


  public static void start(Activity activity) {
    Intent intent = new Intent(activity, ListViewDetachActivity.class);
    activity.startActivity(intent);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);
    ListView listView = findViewById(R.id.list_view);

    List<HashMap<String, String>> datas = getDatas();
    listView.setAdapter(
        new SimpleAdapter(this, datas, R.layout.item_simple, new String[] { "text" }, new int[] { R.id.tv_1 }));
  }

  private List<HashMap<String, String>> getDatas() {
    ArrayList<HashMap<String, String>> list = new ArrayList<>();
    HashMap<String, String> map;
    for (int i = 0; i < 20; i++) {
      map = new HashMap<>();
      map.put("text", "TextView" + i);
      list.add(map);
    }
    return list;
  }
}
