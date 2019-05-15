package com.example.marius.appvreme.data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Marius on 5/8/2017.
 */

public class Units implements JSONPopulator {
    private String temperature;

    public String getTemperature() {
        return
                temperature;
    }

    @Override
    public void populate(JSONObject data) {

        temperature = data.optString("temperature");
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

}
