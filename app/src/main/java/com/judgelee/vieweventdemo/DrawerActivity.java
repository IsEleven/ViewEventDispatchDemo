package com.judgelee.vieweventdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.judgelee.vieweventdemo.adapter.SimpleFragmentPagerAdapter;
import com.judgelee.vieweventdemo.fragment.SimpleTabFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author: lijiajie
 * Date: 2019/2/27
 * Desc:
 */
public class DrawerActivity extends AppCompatActivity {

  private int mTouchSlop = 0;

  private float lastMotionX;
  private float lastMotionY;

  private String[] titles = new String[] {
      "import", "setting", "data", "evaluate"
  };
  private ViewPager contentVp;
  private ListView drawerLv;
  private TabLayout tabLayout;
  private ViewPager nestedVp;
  private DrawerLayout drawerLayout;

  public static void start(Activity activity) {
    Intent intent = new Intent(activity, DrawerActivity.class);
    activity.startActivity(intent);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_drawer);

    drawerLayout = findViewById(R.id.drawer_layout);
    drawerLv = findViewById(R.id.lv_drawer_left);
    contentVp = findViewById(R.id.vp_content);
    tabLayout = findViewById(R.id.tl_tab);
    nestedVp = findViewById(R.id.vp_nested);

    initDrawerLayout();
    initDrawer();
    initViewPager();
    initTab();
    initNestedViewPager();
  }

  @Override
  public void onBackPressed() {
    if (drawerLayout != null) {
      if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
        drawerLayout.closeDrawers();
        return;
      } else if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
        drawerLayout.closeDrawers();
        return;
      }
    }
    super.onBackPressed();
  }

  private void initDrawerLayout() {
    //drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
    //  @Override
    //  public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
    //
    //  }
    //
    //  @Override
    //  public void onDrawerOpened(@NonNull View drawerView) {
    //    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
    //  }
    //
    //  @Override
    //  public void onDrawerClosed(@NonNull View drawerView) {
    //    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    //  }
    //
    //  @Override
    //  public void onDrawerStateChanged(int newState) {
    //
    //  }
    //});

    drawerLayout.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
          if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
            //drawerLayout.closeDrawers();
          } else if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            drawerLayout.closeDrawer(Gravity.RIGHT);
          }
        }
        return false;
      }
    });

  }

  private void initDrawer() {
    drawerLv.setAdapter(new ArrayAdapter<>(this, R.layout.item_drawer_list, R.id.tv_option, titles));
    drawerLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(DrawerActivity.this, titles[position], Toast.LENGTH_SHORT).show();
        Log.d("DrawerLayout", "onItemClick: " + position + " " + titles[position]);
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
          drawerLayout.closeDrawer(Gravity.LEFT);
        } else if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
          drawerLayout.closeDrawer(Gravity.RIGHT);
        }
      }
    });
  }

  private void initViewPager() {
    List<String> tabContent = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      tabContent.add("这是第" + i + "个Fragment");
    }
    final List<SimpleTabFragment> fragments = new ArrayList<>();
    for (String content : tabContent) {
      fragments.add(SimpleTabFragment.newInstance(content));
    }
    contentVp.setAdapter(new SimpleFragmentPagerAdapter(getSupportFragmentManager(), fragments));
    //contentVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    //  @Override
    //  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    //
    //  }
    //
    //  @Override
    //  public void onPageSelected(int position) {
    //    if (position == fragments.size() - 1) {
    //      drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    //    } else {
    //      drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
    //    }
    //  }
    //
    //  @Override
    //  public void onPageScrollStateChanged(int state) {
    //
    //  }
    //});
  }

  private void initTab() {
    tabLayout.setupWithViewPager(contentVp);
    for (int i = 0; i < 4; i++) {
      TabLayout.Tab tab = tabLayout.getTabAt(i);
      tab.setCustomView(R.layout.tab_simple);
      TextView textView = tab.getCustomView().findViewById(R.id.tv_tab);
      textView.setText("Tab" + i);
    }

    TabLayout.Tab firstTab = tabLayout.getTabAt(0);
    if (firstTab != null) {
      firstTab.getCustomView().setSelected(true);
    }
  }

  private void initNestedViewPager() {
    final List<Integer> colors = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 4; i++) {
      colors.add(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }

    nestedVp.setOnTouchListener(new View.OnTouchListener() {

      @Override
      public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
          case MotionEvent.ACTION_DOWN:
            drawerLayout.requestDisallowInterceptTouchEvent(true);
            break;
          case MotionEvent.ACTION_MOVE:
            float dx = event.getX() - lastMotionX;
            if (dx > mTouchSlop) {
              if (nestedVp.getCurrentItem() == 0) {
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                  drawerLayout.requestDisallowInterceptTouchEvent(false);
                }
              }
            }
            if (dx < -mTouchSlop) {
              if (nestedVp.getCurrentItem() == nestedVp.getAdapter().getCount() - 1) {
                if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                  drawerLayout.requestDisallowInterceptTouchEvent(false);
                }
              }
            }
            break;
          default:
            break;
        }
        lastMotionX = event.getX();
        lastMotionY = event.getY();
        return false;
      }
    });

    nestedVp.setAdapter(new PagerAdapter() {
      @Override
      public int getCount() {
        return colors.size();
      }

      @Override
      public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
      }

      @Override
      public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
      }

      @NonNull
      @Override
      public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = new View(DrawerActivity.this);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setBackgroundColor(colors.get(position));
        container.addView(view);
        return view;
      }
    });
  }
}
