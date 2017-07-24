package com.example.soda.weather_mvp.data.source.remote;

import android.util.Log;

import com.example.soda.weather_mvp.BuildConfig;
import com.example.soda.weather_mvp.data.Weather;
import com.example.soda.weather_mvp.data.source.WeatherDataSource;
import com.example.soda.weather_mvp.data.source.remote.WeatherInter;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by soda on 2017/7/23.
 */

public class WeatherRemoteDataSource implements WeatherDataSource {
    //进行网络的数据获取
    public void getRemoteWeather(String city, final GetWeatherCallback callback){
        //创建OkHttpClient的日志拦截器
        OkHttpClient okHttpClient = new OkHttpClient();

        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
            loggin.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = okHttpClient.newBuilder().addInterceptor(loggin).build();
        }

        final OkHttpClient finalOkHttpClient = okHttpClient;
        //Retrofit进行数据访问，并把格式化好的数据进行回传
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeatherInter.BASE_URL)
                .client(finalOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("MyTest", "before create!");
        WeatherInter weatherInterface = retrofit.create(WeatherInter.class);
        Log.d("MyTest", "after create!");
        Call<Weather> call = weatherInterface.getCall(city,WeatherInter.KEY);
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                String ok = "ok";
                Log.d("MyTest", "status" + response.body().getHeWeather5().get(0).getStatus());
                if (ok.equals(response.body().getHeWeather5().get(0).getStatus())){

                    callback.onWeatherLoaded(response.body());
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                callback.onDataNotAvailable();
            }
        });
    }
}
