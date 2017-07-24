package com.example.soda.weather_mvp.addview;

import com.example.soda.weather_mvp.BasePresenter;
import com.example.soda.weather_mvp.BaseView;

/**
 * Created by soda on 2017/7/24.
 */

public interface AddviewContract {
    interface Presenter extends BasePresenter{}
    interface View extends BaseView<Presenter>{}
}
