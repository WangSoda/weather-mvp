package com.example.soda.weather_mvp.listview;

import com.example.soda.weather_mvp.data.source.WeatherRepository;

/**
 * Created by soda on 2017/7/24.
 */

public class ListviewPresenter implements ListviewContract.Presenter {
    private ListviewFragment mFragment;
    private WeatherRepository mReponsitory;
    public ListviewPresenter(ListviewFragment fragment, WeatherRepository instance) {
        mFragment = fragment;
        mReponsitory = instance;
    }

    @Override
    public void start() {

    }

    @Override
    public void onListviewItemClicked() {

    }

    public void onListviewMenuClicked() {
        mFragment.startAddActivity();
    }
}
