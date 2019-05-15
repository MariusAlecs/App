package com.example.marius.appvreme.data;

import org.json.JSONObject;

/**
 * Created by Marius on 5/8/2017.
 */

public class Condition implements JSONPopulator {
    private int code;
    private int temperature;
    private String description;


    public int getCode() {

        return code;
    }

    public int getTemperature() {

        return temperature;
    }

    public String getDescription() {

        return description;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void populate(JSONObject data) {
        code = data.optInt("code");
        temperature = data.optInt("temp");
        description = data.optString("text");

    }


}