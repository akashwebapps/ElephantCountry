package com.akashwebapps.elephantcountry;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.DatePicker;
import com.applandeo.materialcalendarview.builders.DatePickerBuilder;
import com.applandeo.materialcalendarview.listeners.OnSelectDateListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Calendar;
import java.util.List;

public class SaleActivity extends AppCompatActivity {
    TextView tv_enddate,tv_startdate,spinner_store;
    OnSelectDateListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
        tv_enddate=findViewById(R.id.tv_enddate);
        tv_startdate=findViewById(R.id.tv_startdate);
        spinner_store = findViewById(R.id.spinner_store);

        tv_enddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerBuilder builder = new DatePickerBuilder(SaleActivity.this, listener)
                        .pickerType(CalendarView.ONE_DAY_PICKER);

                DatePicker datePicker = builder.build();
                datePicker.show();



            }
        });
        tv_startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerBuilder builder = new DatePickerBuilder(SaleActivity.this, listener)
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


        setUpSpinner();


    }

    private void setUpSpinner() {

        spinner_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenBottomDialog(SaleActivity.this, getResources().getStringArray(R.array.store), new GetPost() {
                    @Override
                    public void getpos(int pos,String name) {

                        spinner_store.setText(name);

                    }
                });
            }
        });







    }


    public  void OpenBottomDialog(final Activity activity, String[] list, GetPost getPos) {



        View sheetView = activity.getLayoutInflater().inflate(R.layout.layout_bottomsheet, null);
        ViewGroup parentViewGroup = (ViewGroup) sheetView.getParent();
        if (parentViewGroup != null) {
            parentViewGroup.removeAllViews();
        }

        final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(activity);
        mBottomSheetDialog.setContentView(sheetView);
        mBottomSheetDialog.show();
        FrameLayout bottomSheet = mBottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);


        ListView listview = sheetView.findViewById(R.id.listview);

        listview.setAdapter(new CustomAdapter(activity,list));



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                mBottomSheetDialog.dismiss();
                getPos.getpos(i,list[i]);
            }
        });


    }


    public  interface GetPost{
        void getpos(int pos,String list);
    }

    public class CustomAdapter extends BaseAdapter {
        Context context;
        String[] extraList;
        LayoutInflater inflter;

        public CustomAdapter(Context applicationContext, String[] extraList) {
            this.context = applicationContext;
            this.extraList = extraList;
            inflter = (LayoutInflater.from(applicationContext));
        }

        @Override
        public int getCount() {
            return extraList.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = inflter.inflate(R.layout.lyt_spinner_item, null);
            TextView txt_item = view.findViewById(R.id.txt_item);
            //   TextView price = view.findViewById(R.id.txtprice);

            txt_item.setText(extraList[i]);



            return view;
        }
    }


}