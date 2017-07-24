package com.example.soda.weather_mvp.preview.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.soda.weather_mvp.R;
import com.example.soda.weather_mvp.data.Weather;

import java.util.List;

/**
 * Created by soda on 2017/7/24.
 */

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyViewHolder>{
    private List<Weather.HeWeather5Bean.DailyForecastBean> dailyForecastBeen;
    public DailyAdapter(List<Weather.HeWeather5Bean.DailyForecastBean> dailyList){
        dailyForecastBeen = dailyList;
    }
    @Override
    public DailyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.preview_daily_item,parent,false);
        DailyViewHolder holder = new DailyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DailyViewHolder holder, int position) {
        Weather.HeWeather5Bean.DailyForecastBean bean = dailyForecastBeen.get(position);
        Log.d("MyTest","onBindViewHolder");
        holder.daily_date.setText(bean.getDate());
        holder.daily_weather.setText(bean.getCond().getTxt_d());
        holder.daily_temperature_max.setText(bean.getTmp().getMax());
        holder.daily_temperature_min.setText(bean.getTmp().getMin());
    }

    @Override
    public int getItemCount() {
        return dailyForecastBeen.size();
    }

    class DailyViewHolder extends RecyclerView.ViewHolder{
        TextView daily_date;
        TextView daily_weather;
        TextView daily_temperature_max;
        TextView daily_temperature_min;
        public DailyViewHolder(View itemView) {
            super(itemView);
            daily_date = itemView.findViewById(R.id.daily_date);
            daily_weather = itemView.findViewById(R.id.daily_weather);
            daily_temperature_max = itemView.findViewById(R.id.daily_temperature_max);
            daily_temperature_min = itemView.findViewById(R.id.daily_temperature_min);
        }
    }
}
