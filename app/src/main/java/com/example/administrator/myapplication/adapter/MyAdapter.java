package com.example.administrator.myapplication.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11.
 */

public class MyAdapter extends PagerAdapter {
    private List<ImageView> list;

    public MyAdapter(List<ImageView> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position % list.size()));
        return list.get(position % list.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position % list.size()));
    }
}
