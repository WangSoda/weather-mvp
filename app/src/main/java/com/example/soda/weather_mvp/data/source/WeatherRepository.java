package com.example.soda.weather_mvp.data.source;

import android.content.Context;

/**
 * Created by soda on 2017/7/22.
 */

public class WeatherRepository implements WeatherDataSource {
    private static WeatherRepository mRespository;
    private WeatherRepository(){}
    //以单例设计模式返回m层对象
    public static WeatherRepository getInstance() {
        if (mRespository == null){
            mRespository = new WeatherRepository();
        }
        return mRespository;
    }
}
