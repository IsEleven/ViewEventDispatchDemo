package com.judgelee.vieweventdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.judgelee.vieweventdemo.R;

/**
 * 创建时间：2019/1/2.
 * 作者：lijiajie
 * 描述：
 */
public class SimpleTabFragment extends Fragment {

  private static final String KEY_CONTENT = "content";

  public static SimpleTabFragment newInstance(String content) {
    Bundle arguments = new Bundle();
    arguments.putString(KEY_CONTENT, content);
    SimpleTabFragment simpleTabFragment = new SimpleTabFragment();
    simpleTabFragment.setArguments(arguments);
    return simpleTabFragment;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View contentView = inflater.inflate(R.layout.fragment_simple_tab, container, false);
    TextView contentTv = contentView.findViewById(R.id.tv_content);
    contentTv.setText(getArguments() != null ? getArguments().getString(KEY_CONTENT) : null);
    return contentView;
  }
}
