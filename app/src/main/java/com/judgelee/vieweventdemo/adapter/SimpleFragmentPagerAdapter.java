package com.judgelee.vieweventdemo.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.judgelee.vieweventdemo.fragment.SimpleTabFragment;

import java.util.List;

/**
 * 创建时间：2019/1/2.
 * 作者：lijiajie
 * 描述：
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

  private List<SimpleTabFragment> fragments;

  public SimpleFragmentPagerAdapter(FragmentManager fm, List<SimpleTabFragment> fragments) {
    super(fm);
    this.fragments = fragments;
  }

  @Override
  public Fragment getItem(int i) {
    return fragments.get(i);
  }

  @Override
  public int getCount() {
    return fragments.size();
  }
}
