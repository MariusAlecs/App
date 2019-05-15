package com.example.marius.appvreme.data;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.marius.appvreme.MainActivity;
import com.example.marius.appvreme.R;

import java.util.ArrayList;
import java.util.Collections;

public class MainA extends AppCompatActivity {
    Button btn;
    //String[] Locations = {"Bucharest, RO", "Iasi, RO", "Craiova, RO", "Austin, TX", "Londra, UK"};
    ArrayList<String> listP=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listP.add("Bucharest, RO");
        listP.add("Craiova, RO");
        listP.add("Iasi, RO");
        listP.add("Cluj, RO");
        listP.add("Austin, TX");
        listP.add("Londra, UK");


        Collections.sort(listP, String.CASE_INSENSITIVE_ORDER);
        final MainA that = this;
        ArrayAdapter adapter = new ArrayAdapter<String>(that,
                R.layout.weather_listview, listP);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(that, MainActivity.class);
                //intent.putExtra("loc", Locations[position]);
                intent.putStringArrayListExtra("locL",listP);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
    public void clickExit(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainA.this);
        builder.setMessage("Vrei sa iesi?");
        builder.setCancelable(true);
        builder.setPositiveButton("DA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("NU", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    };
    public void getContact(View view) {
        Intent intent = new Intent(this, contact.class);
       // intent.putExtra("description", description);
        startActivity(intent);
    }

    @Override
     public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainA.this);
        builder.setMessage("Vrei sa iesi?");
        builder.setCancelable(true);
        builder.setPositiveButton("DA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("NU", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }



}
