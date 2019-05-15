package com.example.marius.appvreme;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marius.appvreme.data.Channel;
import com.example.marius.appvreme.data.Condition;
import com.example.marius.appvreme.data.Forecast;
import com.example.marius.appvreme.data.Item;
import com.example.marius.appvreme.data.Units;
import com.example.marius.appvreme.service.WeatherServiceCallback;
import com.example.marius.appvreme.service.YahooWeatherService;

import java.util.ArrayList;

//import static android.R.attr.description;

public class MainActivity extends AppCompatActivity implements WeatherServiceCallback {

    private ImageView weatherIconImageView;
    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;

    private YahooWeatherService service;
    private ProgressDialog dialog;
    String something;
    String description;
    ArrayList<String> listP;
   //ArrayList<String> listS;
    int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        listP= intent.getStringArrayListExtra("locL");
        position=intent.getIntExtra("position",0);
       // int poz=Integer.parseInt(position);

        weatherIconImageView = (ImageView)findViewById(R.id.weatherIconImageView);
        temperatureTextView = (TextView)findViewById(R.id.temperatureTextView);
        conditionTextView = (TextView)findViewById(R.id.conditionTextView);
        locationTextView = (TextView)findViewById(R.id.locationTextView);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service.refreshWeather(listP.get(position));
    }

    void goBack(View v) {
        this.onBackPressed();
    }

    void toForecast(View v) {
        Intent intent = new Intent(this, Forecast.class);
        intent.putExtra("description", description);
        //startActivity(intent);

        NotificationManager notificationmgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        PendingIntent pintent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        Notification notif = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle("Hello")
                .setContentText("Afla daca poti spala masina")
                .setContentIntent(pintent)
                .build();


        notificationmgr.notify(0,notif);
    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();
        Condition condition = channel.getItem().getCondition();
       Units units = channel.getUnits();
            int resourceId = getResources().getIdentifier("drawable/icon_" + item.getCondition().getCode(), null, getPackageName() );

            @SuppressWarnings("deprecation")
            Drawable weatherIconDrawable =  getResources().getDrawable(resourceId);


        weatherIconImageView.setImageDrawable(weatherIconDrawable);
        temperatureTextView.setText((item.getCondition().getTemperature() - 32) *5 / 9  + "\u00B0" + "C");
        description = item.getCondition().getDescription();
        conditionTextView.setText(description);
        locationTextView.setText(service.getLocation());

        

    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}
