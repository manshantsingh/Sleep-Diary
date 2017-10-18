package com.manshantsingh.sleepdiary;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphActivity extends Activity {

    LineChart chart;

    String TAG = "hehe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Log.d(TAG, "about to do shit");
        doShit();
    }
    private void doShit(){

        chart = (LineChart) findViewById(R.id.chart1);

        // TODO: get data from database and set it into the correct format
        ArrayList<Entry> plotData = new ArrayList<Entry>(Arrays.asList(
                new Entry(1,3),
                new Entry(2,2),
                new Entry(3,5),
                new Entry(4,3),
                new Entry(5,8),
                new Entry(6,1)
        ));
        ArrayList<Entry> plotData2 = new ArrayList<Entry>(Arrays.asList(
                new Entry(1,4),
                new Entry(2,4),
                new Entry(3,5),
                new Entry(4,6),
                new Entry(5,8),
                new Entry(6,5)
        ));

        LineDataSet set1 = new LineDataSet(plotData, "DataSet 1");
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setColor(ColorTemplate.getHoloBlue());
        set1.setValueTextColor(ColorTemplate.getHoloBlue());
        set1.setLineWidth(1.5f);
        set1.setDrawCircles(false);
        set1.setDrawValues(false);
        set1.setFillAlpha(65);
        set1.setFillColor(ColorTemplate.getHoloBlue());
        set1.setHighLightColor(Color.rgb(244, 117, 117));
        set1.setDrawCircleHole(false);

        LineDataSet set2 = new LineDataSet(plotData2, "DataSet 2");
        set2.setAxisDependency(YAxis.AxisDependency.LEFT);
        set2.setColor(Color.RED);
        set2.setValueTextColor(Color.RED);
        set2.setLineWidth(1.5f);
        set2.setDrawCircles(false);
        set2.setDrawValues(false);
        set2.setFillAlpha(65);
        set2.setFillColor(ColorTemplate.getHoloBlue());
        set2.setHighLightColor(Color.rgb(244, 117, 117));
        set2.setDrawCircleHole(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1);
        dataSets.add(set2);

        LineData data = new LineData(dataSets);
        data.setValueTextColor(Color.WHITE);
        data.setValueTextSize(9f);

        chart.setData(data);
    }
}
