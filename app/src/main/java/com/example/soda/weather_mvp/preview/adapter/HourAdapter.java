package com.example.soda.weather_mvp.preview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.soda.weather_mvp.R;
import com.example.soda.weather_mvp.data.Weather;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by soda on 2017/7/24.
 */

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {
    private List<Weather.HeWeather5Bean.HourlyForecastBean> mHourList;
    public HourAdapter(List<Weather.HeWeather5Bean.HourlyForecastBean> hourList){
        mHourList = hourList;
    }
    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.preview_hour_item, parent, false);
        HourViewHolder holder = new HourViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        Weather.HeWeather5Bean.HourlyForecastBean bean = mHourList.get(position);
        holder.hour_time.setText(bean.getDate());
        holder.hour_weather.setText(bean.getCond().getTxt());
        holder.hour_temperature.setText(bean.getHum());
    }

    @Override
    public int getItemCount() {
        return mHourList.size();
    }

    class HourViewHolder extends RecyclerView.ViewHolder{
        TextView hour_time;
        TextView hour_weather;
        TextView hour_temperature;
        public HourViewHolder(View itemView) {
            super(itemView);
            hour_time = itemView.findViewById(R.id.hour_time);
            hour_weather = itemView.findViewById(R.id.hour_weather);
            hour_temperature = itemView.findViewById(R.id.hour_temperature);
        }
    }
}
