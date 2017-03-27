package com.ramraj.welcomescreen.util;

import android.content.Context;
import android.util.Log;

/**
 * Created by ramraj on 27/3/17.
 */

public class SharedPreferenceInfoUtil {
    private static final String TAG = SharedPreferenceInfoUtil.class.getSimpleName();
    public static final String SHARED_PREFERENCE_NAME = "DonationApp";
    public static final String FIRST_TIME = "FirstTime";

    public static void addFirstTimeUser(Context context,Boolean value) {
        try {
            SharedPreferenceUtil.addBooleanToSharedPreference(context, SHARED_PREFERENCE_NAME, FIRST_TIME, value);
        } catch (Exception e) {
            Log.d(TAG, "addFirstTimeUser:something went wrong");
            e.printStackTrace();
        }
    }

    public static boolean isIntroShown(Context context) {
        try {
            return SharedPreferenceUtil.readBooleanFromSharedPreference(context, SHARED_PREFERENCE_NAME, FIRST_TIME);
        } catch (Exception e) {
            Log.d(TAG, "addFirstTimeUser:something went wrong");
            e.printStackTrace();
            return false;
        }
    }
}
