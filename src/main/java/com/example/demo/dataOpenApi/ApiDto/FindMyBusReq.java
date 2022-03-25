package com.example.demo.dataOpenApi.ApiDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@AllArgsConstructor
public class FindMyBusReq {
    private int numOfRows = 10;
    private int pageNo = 1;
    private String _type = "json";
    private int cityCode = 0;
    private String routeId = "";

    public FindMyBusReq(int citycode, String routeid) {
        this.cityCode = citycode;
        this.routeId = routeid;
    }

    public MultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();
        map.add("cityCode",String.valueOf(cityCode));
        map.add("routeNo",routeId);
        map.add("numOfRows", String.valueOf(numOfRows));
        map.add("pageNo", String.valueOf(pageNo));
        map.add("routeId",routeId);
        map.add("_type", _type);
        return map;
    }

}
