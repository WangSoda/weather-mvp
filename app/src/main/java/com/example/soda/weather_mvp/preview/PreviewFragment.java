package com.example.soda.weather_mvp.preview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.soda.weather_mvp.R;
import com.example.soda.weather_mvp.R2;
import com.example.soda.weather_mvp.addview.AddviewActivity;
import com.example.soda.weather_mvp.data.Weather;
import com.example.soda.weather_mvp.listview.ListviewActivity;
import com.example.soda.weather_mvp.preview.adapter.DailyAdapter;
import com.example.soda.weather_mvp.preview.adapter.HourAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by soda on 2017/7/23.
 */

public class PreviewFragment extends Fragment implements PreviewContract.View {
    private PreviewContract.Presenter mPresenter;

    public static PreviewFragment getInstance() {

        return new PreviewFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }
    //需要绑定的控件
    //Fragment需要设置的控件
    @BindView(R2.id.preview_title)
    CollapsingToolbarLayout previewTitle;//标题，用于设置某一个地方的地名
    @BindView(R2.id.preview_temperature)
    TextView previewTemperature;//当地的温度

    //preview_daily_forecast recyclerview的布局参数
    @BindView(R2.id.dailayforecast_recyclerview)
    RecyclerView dailyForecast;
    DailyAdapter mDailyAdapter;
    List<Weather.HeWeather5Bean.DailyForecastBean> mDailyList;
    LinearLayoutManager verticalManager;
    //preview_hour_forecast recyclerview的布局参数
    @BindView(R.id.hourforecase_recyclerview)
    RecyclerView hourForecast;
    HourAdapter mHourAdapter;
    List<Weather.HeWeather5Bean.HourlyForecastBean> mHourList;
    LinearLayoutManager horizontalManager;

    View root;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (root == null){

            root = inflater.inflate(R.layout.fragment_preview,container,false);
        }
        ButterKnife.bind(this,root);
        setDailyRecyclerView();
        setHourRecyclerView();


        return root;
    }

    private void setHourRecyclerView() {
        if (mHourList == null){
            mHourList = new ArrayList<>();
        }
        if (mHourAdapter == null){
            mHourAdapter = new HourAdapter(mHourList);
        }
        if (horizontalManager == null){
            horizontalManager = new LinearLayoutManager(getContext());
            horizontalManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        }
        hourForecast.setLayoutManager(horizontalManager);
        hourForecast.setAdapter(mHourAdapter);
    }

    //对Daily的RecyclerView进行配置
    private void setDailyRecyclerView() {
        if (mDailyList == null){
            mDailyList = new ArrayList<>();
        }
        if (mDailyAdapter == null){
            mDailyAdapter = new DailyAdapter(mDailyList);
        }
        if (verticalManager == null){
            verticalManager = new LinearLayoutManager(getContext());
        }

        dailyForecast.setLayoutManager(verticalManager);
        dailyForecast.setAdapter(mDailyAdapter);
    }

    /**
     * 由Activity传入presenter
     * @param presenter
     */
    @Override
    public void setPresenter(PreviewContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void startListviewActivity() {
        ListviewActivity.startListviewActiviry(getContext());
        ListviewActivity.startListviewActiviry(getContext());
    }


    @Override
    public void onGetDailyList(List<Weather.HeWeather5Bean.DailyForecastBean> bean) {
        mDailyList.clear();
        for (Weather.HeWeather5Bean.DailyForecastBean item:
             bean) {
            mDailyList.add(item);
            mDailyList.add(item);
            mDailyList.add(item);
            mDailyList.add(item);
            mDailyList.add(item);
//            Log.d("MyTest","DailyList length = " + item.getDate()+ "max = " + item.getTmp().getMax());
        }

        mDailyAdapter.notifyDataSetChanged();

    }

    @Override
    public void onGetHourList(List<Weather.HeWeather5Bean.HourlyForecastBean> hourBean) {
        mHourList.clear();
        for (Weather.HeWeather5Bean.HourlyForecastBean item:
             hourBean) {
            mHourList.add(item);
        }
        mHourAdapter.notifyDataSetChanged();
    }


}
