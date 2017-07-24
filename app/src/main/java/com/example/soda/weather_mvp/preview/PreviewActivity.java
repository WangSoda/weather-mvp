package com.example.soda.weather_mvp.preview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.soda.weather_mvp.R;
import com.example.soda.weather_mvp.R2;
import com.example.soda.weather_mvp.data.source.WeatherRepository;
import com.example.soda.weather_mvp.util.ActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PreviewActivity extends AppCompatActivity {
    //控件的绑定
    @BindView(R2.id.preview_menu)
    ImageView previewMenu;
    @BindView(R2.id.preview_background)
    LinearLayout backGround;
    //本地变量
    private PreviewPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(this);
        //设置碎片
        PreviewFragment previewFragment = (PreviewFragment)
                getSupportFragmentManager().findFragmentById(R.id.preview_fragment);
        if (previewFragment == null){
            previewFragment = PreviewFragment.getInstance();
            ActivityUtil.addFragmentToActivity(getSupportFragmentManager(),previewFragment,R.id.preview_fragment);
        }

        mPresenter = new PreviewPresenter(previewFragment, WeatherRepository.getInstance());
        previewFragment.setPresenter(mPresenter);
    }
    @OnClick(R2.id.preview_menu)
    void onMenuPressed(View view){
       mPresenter.OnPreViewMenuPressed();
    }


}
