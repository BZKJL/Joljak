package com.example.demo.dataOpenApi.ApiDto;

import com.example.demo.dto.ClientRouteIdReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@AllArgsConstructor
public class RouteReq {
    private int numOfRows = 10;
    private int pageNo = 1;
    private String _type = "json";
    private int cityCode = 0;
    private String routeNo = "";

    public RouteReq(ClientRouteIdReq clientRouteIdReq){
        this.routeNo = clientRouteIdReq.getBus();
        this.cityCode = clientRouteIdReq.getCitycode();
    }

    public MultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();
        map.add("cityCode",String.valueOf(cityCode));
        map.add("routeNo",String.valueOf(routeNo));
        map.add("numOfRows", String.valueOf(numOfRows));
        map.add("pageNo", String.valueOf(pageNo));
        map.add("_type", _type);
        return map;
    }

}
