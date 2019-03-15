package com.judgelee.vieweventdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.judgelee.vieweventdemo.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lijiajie
 * Date: 2019/2/27
 * Desc:
 */
public class ListItemClickActivity extends AppCompatActivity {

  private List<String> datas = new ArrayList<>();

  public static void start(Activity activity) {
    Intent intent = new Intent(activity, ListItemClickActivity.class);
    activity.startActivity(intent);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);

    initDatas();

    ListView listView = findViewById(R.id.list_view);
    listView.setAdapter(new BaseAdapter() {
      @Override
      public int getCount() {
        return datas.size();
      }

      @Override
      public Object getItem(int position) {
        return datas.get(position);
      }

      @Override
      public long getItemId(int position) {
        return position;
      }

      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(ListItemClickActivity.this).inflate(R.layout.item_container_simple, parent, false);
        //TextView textView = view.findViewById(R.id.tv_1);
        TextView textView = view.findViewById(R.id.btn_click);
        //textView.setFocusable(true);
        //textView.setFocusableInTouchMode(true);
        textView.setText(datas.get(position));

        textView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            LogUtils.d("ListView Button onClick");
            Toast.makeText(ListItemClickActivity.this, "text", Toast.LENGTH_SHORT).show();
          }
        });
        return view;
      }
    });

    //listView.setOnClickListener(new View.OnClickListener() {
    //  @Override
    //  public void onClick(View v) {
    //    LogUtils.d("ListView onClick");
    //  }
    //});

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        LogUtils.d("ListView item " + position + " onItemClick");
      }
    });


  }

  private void initDatas() {
    for (int i = 0; i < 25; i++) {
      datas.add("text" + i);
    }
  }
}
