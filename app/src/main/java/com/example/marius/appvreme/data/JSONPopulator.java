package com.example.marius.appvreme.data;

import org.json.JSONObject;

/**
 * Created by Marius on 5/8/2017.
 */

public interface JSONPopulator {
    void populate(JSONObject data);

    JSONObject toJSON();

}
