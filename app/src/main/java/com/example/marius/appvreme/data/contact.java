package com.example.marius.appvreme.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.marius.appvreme.R;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        TextView content = (TextView) findViewById(R.id.textView);
        content.setText("Marius Ghita, Grupa 341A1");
    }
    void tocontact(View v) {
        //Intent intent = new Intent(this, MainA.class);
        //startActivity(intent);
        finish();
    }
}
