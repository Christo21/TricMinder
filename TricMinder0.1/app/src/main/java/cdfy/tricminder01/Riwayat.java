package cdfy.tricminder01;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class Riwayat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);

        LineChart lineChart = (LineChart) findViewById(R.id.chart);
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(30.4f, 0));
        entries.add(new Entry(28.5f, 1));
        entries.add(new Entry(25.0f, 2));
        entries.add(new Entry(30.7f, 3));
        entries.add(new Entry(39.5f, 4));
        entries.add(new Entry(20.0f, 5));

        LineDataSet dataset = new LineDataSet(entries, "kWh");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("10/11");
        labels.add("11/11");
        labels.add("12/11");
        labels.add("13/11");
        labels.add("14/11");
        labels.add("15/11");

        LineData data = new LineData(labels, dataset);
        lineChart.setData(data);
        lineChart.setDescription(" ");
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);

        lineChart.animateY(5000);

        YAxis leftAxis = lineChart.getAxisLeft();

        LimitLine maxLine = new LimitLine(30f, "Maximum limit");
        maxLine.setLineColor(Color.RED);
        maxLine.setLineWidth(2f);
        maxLine.setTextColor(Color.BLACK);
        maxLine.setTextSize(8f);

        leftAxis.addLimitLine(maxLine);
    }
}







