package com.judgelee.vieweventdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.judgelee.vieweventdemo.adapter.TestAdapter;
import com.judgelee.vieweventdemo.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lijiajie
 * Date: 2019/2/26
 * Desc:
 */
public class NestedRecyclerViewActivity extends AppCompatActivity {

  private List<ItemModel> models;

  public static void start(Activity activity) {
    Intent intent = new Intent(activity, NestedRecyclerViewActivity.class);
    activity.startActivity(intent);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recyclerview_nested);

    initModels();

    RecyclerView recyclerView = findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    recyclerView.setAdapter(new TestAdapter(this, models));
  }

  private void initModels() {
    models = new ArrayList<>();
    for (int i = 0; i < 30; i++) {
      if (i % 5 == 0) {
        List<ItemModel> nestedModels = new ArrayList<>();
        for (int j = 0; j < 30; j++) {
          nestedModels.add(new ItemModel("Text" + i + "-" + j, null));
        }
        models.add(new ItemModel("", nestedModels));
      } else {
        models.add(new ItemModel("Text" + i, null));
      }
    }
  }
}
