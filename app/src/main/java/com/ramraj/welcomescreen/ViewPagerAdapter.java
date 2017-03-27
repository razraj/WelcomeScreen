package com.ramraj.welcomescreen;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ramraj on 10/3/17.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    private Context context;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return WelcomePagerEnum.values().length > 0 ? WelcomePagerEnum.values().length : 0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        WelcomePagerEnum welcomePagerEnum = WelcomePagerEnum.values()[position];
        layoutInflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) layoutInflater.inflate(welcomePagerEnum.getLayoutResourceId(), container, false);
        container.addView(layout);
        return layout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

}
