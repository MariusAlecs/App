package com.example.marius.appvreme.data;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.marius.appvreme.R;

public class Forecast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast2);

        Intent intent = getIntent();
        String description = intent.getStringExtra("description");

        if (description.equals("Clear") || description.equals("Sunny") || description.equals("Partly Cloudy")) {
            TextView content = (TextView) findViewById(R.id.textView);
            content.setText("Poti spala masina!");
        } else {
            TextView content = (TextView) findViewById(R.id.textView);
            content.setText("Nu spala masina!");
        }

    }
    void goBack(View v) {
        this.onBackPressed();
    }
}
