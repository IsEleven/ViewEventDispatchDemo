package com.judgelee.vieweventdemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.judgelee.vieweventdemo.R;
import com.judgelee.vieweventdemo.model.ItemModel;

import java.util.List;
import java.util.Random;

/**
 * Author: lijiajie
 * Date: 2019/2/26
 * Desc:
 */
public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private final int NORMAL = 1;
  private final int HORIZONTAL = 2;

  private Context context;
  private List<ItemModel> models;

  public TestAdapter(Context context, List<ItemModel> models) {
    this.context = context;
    this.models = models;
  }

  @Override
  public int getItemViewType(int position) {
    ItemModel itemModel = models.get(position);
    if (itemModel.getItemModels() != null && itemModel.getItemModels().size() != 0) {
      return HORIZONTAL;
    } else {
      return NORMAL;
    }
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view;
    if (viewType == HORIZONTAL) {
      view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
      return new HorizontalViewHolder(view);
    } else {
      view = LayoutInflater.from(context).inflate(R.layout.item_simple, parent, false);
      return new NormalViewHolder(view);
    }
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    ItemModel itemModel = models.get(position);
    if (holder instanceof NormalViewHolder) {
      ((NormalViewHolder) holder).textView.setText(itemModel.getContent());
      Random random = new Random();
      ((NormalViewHolder) holder).textView.setBackgroundColor(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    } else if (holder instanceof HorizontalViewHolder) {
      ((HorizontalViewHolder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
      ((HorizontalViewHolder) holder).recyclerView.setAdapter(new TestAdapter(context, itemModel.getItemModels()));
    }
  }

  @Override
  public int getItemCount() {
    return models.size();
  }

  class NormalViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public NormalViewHolder(@NonNull View itemView) {
      super(itemView);
      textView = itemView.findViewById(R.id.tv_1);
    }
  }

  class HorizontalViewHolder extends RecyclerView.ViewHolder {

    RecyclerView recyclerView;

    public HorizontalViewHolder(@NonNull View itemView) {
      super(itemView);
      recyclerView = itemView.findViewById(R.id.recycler_view_nested);
    }
  }
}
