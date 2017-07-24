package com.example.soda.weather_mvp.data.source.remote;

import com.example.soda.weather_mvp.data.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by soda on 2017/7/23.
 */

public interface WeatherInter {
    String BASE_URL = "https://free-api.heweather.com/v5/";
    String KEY = "953076504241430cb06bad08e56ec6f2";
    @GET("weather")
    Call<Weather> getCall(@Query("city") String localcity, @Query("key") String keys);

}
