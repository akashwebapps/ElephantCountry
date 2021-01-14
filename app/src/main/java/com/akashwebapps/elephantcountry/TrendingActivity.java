package com.akashwebapps.elephantcountry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.DatePicker;
import com.applandeo.materialcalendarview.builders.DatePickerBuilder;
import com.applandeo.materialcalendarview.listeners.OnSelectDateListener;

import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TrendingActivity extends AppCompatActivity {

    TextView tv_enddate,tv_startdate;

    OnSelectDateListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);
        tv_enddate=findViewById(R.id.tv_enddate);
        tv_startdate=findViewById(R.id.tv_startdate);

        tv_enddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerBuilder builder = new DatePickerBuilder(TrendingActivity.this, listener)
                        .pickerType(CalendarView.ONE_DAY_PICKER);

                DatePicker datePicker = builder.build();
                datePicker.show();



            }
        });
        tv_startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerBuilder builder = new DatePickerBuilder(TrendingActivity.this, listener)
                        .pickerType(CalendarView.ONE_DAY_PICKER);

                DatePicker datePicker = builder.build();
                datePicker.show();



            }
        });

          listener = new OnSelectDateListener() {
            @Override
            public void onSelect(List<Calendar> calendars) {


            }
        };




    }


}