package com.example.soda.weather_mvp.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by soda on 2017/7/23.
 */

public class ActivityUtil {
    public static void addFragmentToActivity(FragmentManager fragmentManager, Fragment fragment,
                                             int fragmentId){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragmentId,fragment);
        transaction.commit();
    }
}
