package com.example.demo.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataClient {


    private String dataClientId;

    public String getNearBusStationByGps;
    public String getRouteIdByBusNo;
    public String getArriveByStationAndBusNo;
    public String getLocationByBusNo;

}
