package com.judgelee.vieweventdemo.model;

import java.util.List;

/**
 * Author: lijiajie
 * Date: 2019/2/26
 * Desc:
 */
public class ItemModel {

  private String content;

  private List<ItemModel> itemModels;

  public ItemModel(String content, List<ItemModel> itemModels) {
    this.content = content;
    this.itemModels = itemModels;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public List<ItemModel> getItemModels() {
    return itemModels;
  }

  public void setItemModels(List<ItemModel> itemModels) {
    this.itemModels = itemModels;
  }
}
