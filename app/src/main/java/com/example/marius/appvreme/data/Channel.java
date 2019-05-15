package com.example.marius.appvreme.data;

import org.json.JSONObject;

/**
 * Created by Marius on 5/8/2017.
 */

public class Channel implements JSONPopulator {
    private Units units;
    private Item item;

    public Units getUnits() {

        return units;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    public Item getItem() {

        return item;
    }

    @Override
    public void populate(JSONObject data) {

        units = new Units();
        units.populate(data.optJSONObject("units"));

        item = new Item();
        item.populate(data.optJSONObject("item"));
    }


}