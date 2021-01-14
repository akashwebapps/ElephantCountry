package com.akashwebapps.elephantcountry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

public class DashBordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_bord);

        GraphView linegraph = (GraphView) findViewById(R.id.line_graph);

        BarGraphSeries<DataPoint> lineSeries = new BarGraphSeries<>(new DataPoint[] {

                // date 1st january -7 th, renvenue 5k -20k
                new DataPoint(05, 1542),
                new DataPoint(1542, 525),
                new DataPoint(224, 3524),
                new DataPoint(3245, 2524),
                new DataPoint(4254, 6524)
        });



        linegraph.addSeries(lineSeries);



        findViewById(R.id.stock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBordActivity.this,StockReportActivity.class));
            }
        }); findViewById(R.id.Sale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBordActivity.this,SaleActivity.class));
            }
        });findViewById(R.id.Alert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBordActivity.this,AlertActivity.class));
            }
        });findViewById(R.id.Trending).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBordActivity.this,TrendingActivity.class));
            }
        });findViewById(R.id.statistic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBordActivity.this,StatisticActivity.class));
            }
        });
    }
}