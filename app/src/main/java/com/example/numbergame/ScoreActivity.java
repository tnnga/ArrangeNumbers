package com.example.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        time = (TextView) findViewById(R.id.scoreTime);
        Intent myIntent = new Intent();
        String str = myIntent.getStringExtra("mykey");
        String sessionId = getIntent().getStringExtra("timeCurrent");
        if(sessionId == null){sessionId = "0";};
        time.setText("Time: "+sessionId);

    }
}