package com.akashwebapps.elephantcountry;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tiper.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;

public class StatisticActivity extends AppCompatActivity {
    private TextView spinner_store, spinner_category, spinner_item;



    private String[] category = {"All Category", "Accessories", "Apparels", "Books", "Home Accessories", "Food Items"};

    int position=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        spinner_store = findViewById(R.id.spinner_store);
        spinner_category = findViewById(R.id.spinner_category);
        spinner_item = findViewById(R.id.spinner_item);



        setUpSpinner();
    }

    private void setUpSpinner() {

        spinner_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenBottomDialog(StatisticActivity.this, getResources().getStringArray(R.array.store), new GetPost() {
                    @Override
                    public void getpos(int pos,String name) {

                        spinner_store.setText(name);

                    }
                });
            }
        });


        spinner_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenBottomDialog(StatisticActivity.this, category, new GetPost() {
                    @Override
                    public void getpos(int pos,String name) {

                        position=pos;
                        spinner_category.setText(name);
                    }
                });
            }
        });

        spinner_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
             String[] list = new String[0];
                if (position==0){
                    list=getResources().getStringArray(R.array.item);
                }
                if (position==1){
                    list=getResources().getStringArray(R.array.Accessories);
                }
                if (position==2){
                    list=getResources().getStringArray(R.array.Apparels);
                }
                if (position==3){
                    list=getResources().getStringArray(R.array.Books);
                }if (position==4){
                    list=getResources().getStringArray(R.array.HomeAccessories);
                }if (position==5){
                    list=getResources().getStringArray(R.array.FoodItems);
                }
                
                

                
                OpenBottomDialog(StatisticActivity.this, list, new GetPost() {
                    @Override
                    public void getpos(int pos,String name) {

                        spinner_item.setText(name);
                    }
                });
            }
        });





    }


    public  void OpenBottomDialog(final Activity activity,String[] list,GetPost getPos) {



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