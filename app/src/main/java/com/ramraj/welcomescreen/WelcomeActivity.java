package com.ramraj.welcomescreen;

import android.animation.ArgbEvaluator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ramraj.welcomescreen.util.SharedPreferenceInfoUtil;

import me.relex.circleindicator.CircleIndicator;

public class WelcomeActivity extends CoreActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private CircleIndicator circleIndicator;
    private View skip, next;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    /*color for sliders*/
    private int[] color;

    /*required for color change transition*/
    private ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (SharedPreferenceInfoUtil.isIntroShown(getContext())) {
            startHomeActivity();
            finish();
        }

        color = new int[]{
                getContext().getResources().getColor(R.color.bg_screen1),
                getContext().getResources().getColor(R.color.bg_screen2),
                getContext().getResources().getColor(R.color.bg_screen3)
        };

        //set ViewPager adapter
        pagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        //set viewPager Indicator
        circleIndicator.setViewPager(viewPager);

    }

    @Override
    protected void bindViews() {
        circleIndicator = (CircleIndicator) findViewById(R.id.circulator_indicator);
        skip = findViewById(R.id.skip);
        next = findViewById(R.id.next);
        viewPager = (ViewPager) findViewById(R.id.intro_silder_pager);
    }

    @Override
    protected void setListeners() {
        skip.setOnClickListener(this);
        next.setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.next:
                if (viewPager.getCurrentItem() < 2)
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                else
                    startHomeActivity();
                break;
            case R.id.skip:
                startHomeActivity();
                break;
        }
    }

    private void startHomeActivity() {
        SharedPreferenceInfoUtil.addFirstTimeUser(getContext(), true);
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }


    /*viewPager Page change listener starting*/

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position < (pagerAdapter.getCount() - 1) && position < (color.length - 1)) {
            viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, color[position], color[position + 1]));
        } else {
            viewPager.setBackgroundColor(color[color.length - 1]);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /*viewPager Page change listener ending*/

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
