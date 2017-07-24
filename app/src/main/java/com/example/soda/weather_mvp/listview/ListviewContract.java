package com.example.soda.weather_mvp.listview;

import com.example.soda.weather_mvp.BasePresenter;
import com.example.soda.weather_mvp.BaseView;

/**
 * Created by soda on 2017/7/24.
 */

public interface ListviewContract {
    interface Presenter extends BasePresenter{
        void onListviewItemClicked();
    }
    interface View extends BaseView<Presenter>{
        void startAddActivity();
    }
}
