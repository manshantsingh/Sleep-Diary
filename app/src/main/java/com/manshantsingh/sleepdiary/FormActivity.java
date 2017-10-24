package com.manshantsingh.sleepdiary;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class FormActivity extends Activity {

    private static String TAG = "hehe";

    private ViewPager viewPager;
    private ViewPageAdapter viewPageAdapter;
    private LinearLayout progressBarLayout;
    private int[] layouts;
    private Button btnNext, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        progressBarLayout = (LinearLayout) findViewById(R.id.layoutProgressBar);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnBack = (Button) findViewById(R.id.btn_back);

        layouts = new int[]{
                R.layout.form_page1,
                R.layout.form_page2,
                R.layout.form_page3
        };

        updateProgressBar(0);

        viewPageAdapter = new ViewPageAdapter();
        viewPager.setAdapter(viewPageAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int next = viewPager.getCurrentItem() + 1;
                if (next < layouts.length) {
                    viewPager.setCurrentItem(next);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int back = viewPager.getCurrentItem() - 1;
                if (back >= 0) {
                    viewPager.setCurrentItem(back);
                }
            }
        });
    }

    private void updateProgressBar(int currentPosition) {

        progressBarLayout.removeAllViews();

        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(50,20);
        lp.setMargins(5,0,5,0);

        Drawable on = ResourcesCompat.getDrawable(getResources(), R.drawable.r_progress_bar_box_on, null);
        Drawable off = ResourcesCompat.getDrawable(getResources(), R.drawable.r_progress_bar_box_off, null);


        for (int i = 0; i <= currentPosition; i++) {
            View v = new View(this);
            v.setLayoutParams(lp);
            v.setBackground(on);
            progressBarLayout.addView(v);
        }
        for (int i = currentPosition + 1; i < layouts.length; i++) {
            View v = new View(this);
            v.setLayoutParams(lp);
            v.setBackground(off);
            progressBarLayout.addView(v);
        }
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            updateProgressBar(position);

            // TODO: do other stuff too
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    public class ViewPageAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = getLayoutInflater().inflate(layouts[position], container, false);
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
