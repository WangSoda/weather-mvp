package com.example.soda.weather_mvp.preview;

import com.example.soda.weather_mvp.data.Weather;
import com.example.soda.weather_mvp.data.source.WeatherDataSource;
import com.example.soda.weather_mvp.data.source.WeatherRepository;
import com.example.soda.weather_mvp.data.source.remote.WeatherRemoteDataSource;

import java.util.List;

/**
 * Created by soda on 2017/7/23.
 */

public class PreviewPresenter implements PreviewContract.Presenter ,
WeatherDataSource.GetWeatherCallback{
    private PreviewContract.View mView;
    private WeatherDataSource mDataSource;

    public PreviewPresenter(PreviewFragment previewFragment, WeatherRepository instance) {
        if (previewFragment != null){
            mView = previewFragment;
        }if (instance != null){
            mDataSource = instance;
        }
        start();
    }

    @Override
    public void start() {
        WeatherRemoteDataSource dataSource = new WeatherRemoteDataSource();
        dataSource.getRemoteWeather("吉林",this);
    }

    public void OnPreViewMenuPressed() {
        mView.startListviewActivity();
    }

    @Override
    public void onWeatherLoaded(Weather weather) {
        Weather.HeWeather5Bean weather5Bean = weather.getHeWeather5().get(0);
        List<Weather.HeWeather5Bean.DailyForecastBean> dailyBean =
                weather5Bean.getDaily_forecast();
        mView.onGetDailyList(dailyBean);
        List<Weather.HeWeather5Bean.HourlyForecastBean> hourBean =
                weather5Bean.getHourly_forecast();
        mView.onGetHourList(hourBean);
    }

    @Override
    public void onDataNotAvailable() {

    }
}
