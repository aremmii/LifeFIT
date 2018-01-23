package com.thailife.app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by PromptNow5 on 11/27/2017.
 */

public class SharedPref {

    private static final String SHARED_NAME = "SHARED_PREFERENCE_TL";

    public static SharedPreferences getSharedPref(Context context) {
        return context.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
    }

    public static void setIsLogin(Context context,boolean value) {
        getSharedPref(context).edit().putBoolean("IsLogin",value).apply();
    }

    public static boolean getIsLogin(Context context) {
       return getSharedPref(context).getBoolean("IsLogin", false);
    }
}
