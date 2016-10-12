package com.example.administrator.myapplication.activity;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements ViewPager.OnPageChangeListener{
    private TextView tv;
    private ViewPager vp;
    private List<ImageView>list;
    private ImageView img;
    private int index=400;
    private int num=1;
    private long  time;
    private Handler handler=new Handler();
    private int[]i=new int[]{R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e,
            R.mipmap.f,R.mipmap.g,R.mipmap.h};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tv= (TextView) findViewById(R.id.tv);
        vp= (ViewPager) findViewById(R.id.vp);
        list=new ArrayList<>();

        for (int j=0;j<i.length;j++){
            img=new ImageView(this);
            img.setImageResource(i[j]);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            list.add(img);
        }
        tv.setText(num+"/"+list.size());
        MyAdapter adapter=new MyAdapter(list);
        vp.setAdapter(adapter);
        vp.setCurrentItem(index);
        vp.setOnPageChangeListener(this);
        handler.postDelayed(myRunnable,2000);
    }
     MyRunnable myRunnable=new MyRunnable();

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
           vp.setCurrentItem(position);
           index=position;
            time=System.currentTimeMillis();
            tv.setText((position%list.size()+1)+"/"+list.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class MyRunnable implements Runnable{

        @Override
        public void run() {
            if(System.currentTimeMillis()-time>=2000){
                num++;
                index++;
                vp.setCurrentItem(index);
            }
            handler.postDelayed(myRunnable,2000);
        }
    }
}
