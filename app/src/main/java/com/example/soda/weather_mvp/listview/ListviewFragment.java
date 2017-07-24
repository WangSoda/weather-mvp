package com.example.soda.weather_mvp.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.soda.weather_mvp.R;
import com.example.soda.weather_mvp.R2;
import com.example.soda.weather_mvp.addview.AddviewActivity;
import com.example.soda.weather_mvp.data.Weather;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by soda on 2017/7/24.
 */

public class ListviewFragment extends Fragment implements ListviewContract.View {
    ListviewContract.Presenter mPresenter;
    private static ListviewFragment mListviewFragment;

    public static ListviewFragment getInstance() {
        if (mListviewFragment == null){
            mListviewFragment = new ListviewFragment();
        }
        return mListviewFragment;
    }

    @Override
    public void setPresenter(ListviewContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        //start()
    }

    View root;
    //Recyclerview的设定内容
    @BindView(R2.id.list_recycler)
    RecyclerView mListviewRecycler;
    LinearLayoutManager mVerticalLayoutManager;
    List<Weather> mWeatherList;
    ListViewItemAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_listview,container,false);
        ButterKnife.bind(this,root);
        setListRecyclerViewAdapter();
        return root;
    }

    /**
     * 当activity 的 menu 被点击时回调此方法
     */
    @Override
    public void startAddActivity() {
        AddviewActivity.startAddviewActivity(getContext());
    }

    class ListViewItemAdapter extends RecyclerView.Adapter<ListViewItemAdapter.ListItemViewHolder> {
        private List<Weather> mList;
        public ListViewItemAdapter(List<Weather> list){
            mList = list;
        }
        @Override
        public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(parent.getContext(),R.layout.listview_item_simple,parent);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPresenter.onListviewItemClicked();
                }
            });
            ListItemViewHolder holder = new ListItemViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ListItemViewHolder holder, int position) {
            Weather weather = mList.get(position);
            holder.listview_item_time.setText(weather.getHeWeather5().get(0).getBasic().getUpdate().getLoc());
            holder.listview_item_city.setText(weather.getHeWeather5().get(0).getBasic().getCity());
            holder.listview_item_temperature.setText(weather.getHeWeather5().get(0).getNow().getTmp());
        }


        @Override
        public int getItemCount() {
            return mList.size();
        }

        class ListItemViewHolder extends RecyclerView.ViewHolder{
            TextView listview_item_time;
            TextView listview_item_city;
            TextView listview_item_temperature;
            public ListItemViewHolder(View itemView) {
                super(itemView);
                listview_item_time = itemView.findViewById(R.id.listview_item_time);
                listview_item_city = itemView.findViewById(R.id.listview_item_city);
                listview_item_temperature = itemView.findViewById(R.id.listview_item_temperature);
            }
        }
    }
    private void setListRecyclerViewAdapter() {
        if (mVerticalLayoutManager == null){
            mVerticalLayoutManager = new LinearLayoutManager(getContext());
        }if (mWeatherList == null){
            mWeatherList = new ArrayList<>();
        }if (mAdapter == null){
            mAdapter = new ListViewItemAdapter(mWeatherList);
        }
        mListviewRecycler.setLayoutManager(mVerticalLayoutManager);
        mListviewRecycler.setAdapter(mAdapter);
    }
}
