package com.example.marius.appvreme.service;

import com.example.marius.appvreme.data.Channel;

/**
 * Created by Marius on 5/8/2017.
 */

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
