package com.akashwebapps.elephantcountry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class StatisticActivity extends AppCompatActivity {
    private Spinner spinner_store, spinner_category, spinner_item;


    private String[] store = {"All Store"};
    private String[] category = {"All Category", "Accessories", "Apparels", "Books", "Home Accessories", "Food Items"};

    private List<ArrayList<String>> list = new ArrayList<>();
    private String[] item = {};

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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, store);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_store.setAdapter(adapter);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, category);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_category.setAdapter(adapter1);


        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i==0){

                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(StatisticActivity.this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.store));
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_item.setAdapter(adapter1);
                }

                if (i==1){

                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(StatisticActivity.this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Accessories));
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_item.setAdapter(adapter1);
                }
                if (i==2){

                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(StatisticActivity.this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Apparels));
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_item.setAdapter(adapter1);
                } if (i==3){

                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(StatisticActivity.this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Books));
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_item.setAdapter(adapter1);
                } if (i==4){

                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(StatisticActivity.this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.HomeAccessories));
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_item.setAdapter(adapter1);
                }if (i==5){

                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(StatisticActivity.this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.FoodItems));
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_item.setAdapter(adapter1);
                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

}