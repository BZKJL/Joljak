package com.example.demo.service;


import com.example.demo.dto.GPSCoordinateReq;
import com.example.demo.dto.GPSCoordinateRes;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ExternalAPIService {

    public String getNearBusStationByGps(GPSCoordinateReq req){
        String API_SERVICE_KEY = "OSsqksel6JSVbZDK+DpRzUJMPzeHMRUOrqysyrIxSOfyQSYEv82iDk+e72rzXSRHcJZ34UBYb4xAEL75bpzFEw==";
        String GET_STATION_BY_GPS = "http://apis.data.go.kr/1613000/BusSttnInfoInqireService/getCrdntPrxmtSttnList";
        HttpResponse<JsonNode> response = (HttpResponse<JsonNode>) Unirest.get(GET_STATION_BY_GPS)
                .queryString("serviceKey",API_SERVICE_KEY)
                .queryString("numOfRows",10)
                .queryString("pageNo",1)
                .queryString("gpsLati",req.getLatitude())
                .queryString("gpsLong",req.getLongitude())
                .queryString("_type","json")
                .asJson();

        System.out.println(response);
        System.out.println(response.getBody());
        JSONObject object = response.getBody().getObject();
        GPSCoordinateRes res = new GPSCoordinateRes(object);
        return "heelololo";
    }

}
