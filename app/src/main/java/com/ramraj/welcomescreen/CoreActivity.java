package com.ramraj.welcomescreen;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ramraj on 10/3/17.
 */

public abstract class CoreActivity extends AppCompatActivity {
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        bindViews();
        setContext(this);
        setListeners();
    }

    /**
     * method to bind all views related to resourceLayout
     */
    protected abstract void bindViews();

    /**
     * called to set view listener for views
     */
    protected abstract void setListeners();
}
