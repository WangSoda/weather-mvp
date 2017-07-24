package com.example.soda.weather_mvp;

/**
 * Created by soda on 2017/7/23.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
