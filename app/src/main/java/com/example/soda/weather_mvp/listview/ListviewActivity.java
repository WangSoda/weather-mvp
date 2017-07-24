package com.example.soda.weather_mvp.listview;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.soda.weather_mvp.R;
import com.example.soda.weather_mvp.R2;
import com.example.soda.weather_mvp.data.source.WeatherRepository;
import com.example.soda.weather_mvp.util.ActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListviewActivity extends AppCompatActivity {
    public static void startListviewActiviry(Context context){
        Intent intent = new Intent(context,ListviewActivity.class);
        context.startActivity(intent);
    }

    ListviewFragment mFragment;
    ListviewPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ButterKnife.bind(this);

        mFragment = (ListviewFragment) getSupportFragmentManager().findFragmentById(R.id.listview_fragment);
        if (mFragment == null){
            mFragment = ListviewFragment.getInstance();
        }
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(),mFragment,R.id.listview_fragment);

        mPresenter = new ListviewPresenter(mFragment, WeatherRepository.getInstance());
        mFragment.setPresenter(mPresenter);
    }
    @OnClick(R2.id.listview_menu)
    void onMenuClicked(View view){
        mPresenter.onListviewMenuClicked();
    }
}
