package com.example.demo.dataOpenApi.ApiDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@AllArgsConstructor
public class StationListReq {
    private int numOfRows = 200;
    private int pageNo = 1;
    private String _type = "json";
    private int cityCode = 0;
    private String routeId = "";

    public StationListReq(String routeid, int citycode) {
        this.routeId = routeid;
        this.cityCode = citycode;
    }

    public MultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();
        map.add("pageNo", String.valueOf(pageNo));
        map.add("numOfRows", String.valueOf(numOfRows));
        map.add("_type", _type);
        map.add("cityCode",String.valueOf(cityCode));
        map.add("routeId",routeId);
        return map;
    }

}
