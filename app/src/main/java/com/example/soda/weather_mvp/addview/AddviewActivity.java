package com.example.soda.weather_mvp.addview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.soda.weather_mvp.R;

public class AddviewActivity extends AppCompatActivity {
    public static void startAddviewActivity(Context context){
        Intent intent = new Intent(context,AddviewActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
}
