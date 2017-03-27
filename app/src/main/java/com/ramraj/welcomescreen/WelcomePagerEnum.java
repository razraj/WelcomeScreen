package com.ramraj.welcomescreen;

/**
 * Created by ramraj on 27/3/17.
 */

public enum WelcomePagerEnum {
    SCREEN1(R.string.slide_1_title, R.layout.welcome_slider1),
    SCREEN2(R.string.slide_1_title, R.layout.welcome_slider2),
    SCREEN3(R.string.slide_1_title, R.layout.welcome_slider3);

    private int titleResourceId;
    private int layoutResourceId;

    WelcomePagerEnum(int titleResourceId, int layoutResourceId) {
        this.titleResourceId = titleResourceId;
        this.layoutResourceId = layoutResourceId;
    }

    public int getTitleResourceId() {
        return titleResourceId;
    }

    public int getLayoutResourceId() {
        return layoutResourceId;
    }
}
