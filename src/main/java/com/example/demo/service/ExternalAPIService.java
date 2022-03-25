package com.example.demo.service;


import com.example.demo.dataOpenApi.ApiDto.GPSCoordinateReq;
import com.example.demo.dataOpenApi.ApiDto.GPSCoordinateRes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
public class ExternalAPIService {

    public String getNearBusStationByGps(GPSCoordinateReq req){
        String API_SERVICE_KEY = "OSsqksel6JSVbZDK+DpRzUJMPzeHMRUOrqysyrIxSOfyQSYEv82iDk+e72rzXSRHcJZ34UBYb4xAEL75bpzFEw==";
        String GET_STATION_BY_GPS = "http://apis.data.go.kr";
        String PATH ="/1613000/BusSttnInfoInqireService/getCrdntPrxmtSttnList";

        URI uri = UriComponentsBuilder
                .fromUriString(GET_STATION_BY_GPS)
                .path(PATH)
                .queryParam("serviceKey",API_SERVICE_KEY)
                .queryParam("numOfRows",10)
                .queryParam("pageNo",1)
                .queryParam("gpsLati",req.getGpsLati())
                .queryParam("gpsLong",req.getGpsLong())
                .queryParam("_type","json")
                .build()
                .toUri();
        /*HttpResponse<JsonNode> response = (HttpResponse<JsonNode>) Unirest.get(GET_STATION_BY_GPS)
                .queryString("serviceKey",API_SERVICE_KEY)
                .queryString("numOfRows",10)
                .queryString("pageNo",1)
                .queryString("gpsLati",req.getLatitude())
                .queryString("gpsLong",req.getLongitude())
                .queryString("_type","json")
                .asJson();
*/
        //System.out.println(response);
        //System.out.println(response.getBody());


        //JSONObject object = response.getBody().getObject();
        //GPSCoordinateRes res = new GPSCoordinateRes(object);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GPSCoordinateRes> result = restTemplate.getForEntity(uri, GPSCoordinateRes.class);
        return "heelololo";
    }

}
