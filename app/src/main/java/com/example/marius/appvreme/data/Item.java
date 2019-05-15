package com.example.marius.appvreme.data;

import org.json.JSONObject;

/**
 * Created by Marius on 5/9/2017.
 */

public class Item implements JSONPopulator {
    private Condition condition;


    public Condition getCondition() {

        return condition;
    }


    @Override
    public void populate(JSONObject data) {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));

    }

    @Override
    public JSONObject toJSON() {
        return null;
    }
}