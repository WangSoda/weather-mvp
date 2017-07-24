package com.example.soda.weather_mvp.data.source;

import com.example.soda.weather_mvp.data.Weather;

import java.util.List;

/**
 * Created by soda on 2017/7/22.
 */

public interface WeatherDataSource {
    /**
     * 异步任务回调接口
     */
    interface LoadWeathersCallback{
        void onWeatherLoaded(List<Weather> weathers);
        void onDataNotAvailable();
    }
    interface GetWeatherCallback{
        void onWeatherLoaded(Weather weather);
        void onDataNotAvailable();
    }
}
