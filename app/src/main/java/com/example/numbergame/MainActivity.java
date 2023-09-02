package com.example.numbergame;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    TextView time;
    TextView txtTime;
    TextView txtLanguage;
    TextView txtSetLanguage;
    Button btStart;
    ArrayAdapter arrayAdapter;

    Spinner spinner;
    String[] array = new String[100];
    private int[] colors = {
            Color.RED,
            Color.GREEN,
            Color.BLUE
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            int ran = random.nextInt(100) + 1;
            array[i] = String.valueOf(ran);
        }

        gridView = (GridView) findViewById(R.id.gridView);
        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1, array);
        gridView.setAdapter(arrayAdapter);

        time = (TextView) findViewById(R.id.time);
        new CountDownTimer(300000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText("  " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                time.setText("Time out!");
            }
        }.start();

        txtTime = (TextView) findViewById(R.id.txtTime);
        txtLanguage = (TextView) findViewById(R.id.txtLanguage);
        txtSetLanguage = (TextView) findViewById(R.id.txtSetLanguage);
        btStart = (Button) findViewById(R.id.btStart);
        spinner = (Spinner) findViewById(R.id.language);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"EN", "VI"}));


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        txtSetLanguage.setText("EN");
                        txtTime.setText("   Time:");
                        txtLanguage.setText("Language");
                        btStart.setText("Start");
                        break;
                    case 1:
                        txtSetLanguage.setText("VI");
                        txtTime.setText("   Thời gian:");
                        txtTime.setTextSize(14);
                        txtLanguage.setText("Ngôn ngữ");
                        txtLanguage.setTextSize(15);
                        btStart.setText("Bắt đầu");
                        btStart.setTextSize(22);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }
}