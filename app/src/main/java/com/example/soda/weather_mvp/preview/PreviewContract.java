package com.example.soda.weather_mvp.preview;

import com.example.soda.weather_mvp.BasePresenter;
import com.example.soda.weather_mvp.BaseView;
import com.example.soda.weather_mvp.data.Weather;

import java.util.List;

/**
 * Created by soda on 2017/7/23.
 */

public interface PreviewContract {
    interface Presenter extends BasePresenter{}
    interface View extends BaseView<Presenter>{
        //该方法用于启动数据添加的
        void startListviewActivity();

        //DailyList数据回调接口
        void onGetDailyList(List<Weather.HeWeather5Bean.DailyForecastBean> bean);

        void onGetHourList(List<Weather.HeWeather5Bean.HourlyForecastBean> hourBean);
    }
}
