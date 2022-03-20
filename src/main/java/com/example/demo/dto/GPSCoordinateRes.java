package com.example.demo.dto;

import kong.unirest.json.JSONObject;
import lombok.Getter;
import lombok.Value;

@Value
public class GPSCoordinateRes {

    private JSONObject object;

    public GPSCoordinateRes(JSONObject object) {

        this.object = object;
    }


}
