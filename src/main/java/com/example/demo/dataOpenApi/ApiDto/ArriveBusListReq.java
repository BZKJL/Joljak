package com.example.demo.dataOpenApi.ApiDto;

import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
public class ArriveBusListReq {

    private int numOfRows = 50;
    private int pageNo = 1;
    private String _type = "json";
    private int cityCode = 0;
    private String nodeId = "";
    private String routeId = "";

    public ArriveBusListReq(String nodeid, int citycode, String routeid) {
        this.nodeId = nodeid;
        this.cityCode = citycode;
        this.routeId = routeid;
    }

    public MultiValueMap<String, String> toMultiValueMap() {
        var map = new LinkedMultiValueMap<String, String>();
        map.add("pageNo", String.valueOf(pageNo));
        map.add("numOfRows", String.valueOf(numOfRows));
        map.add("_type", _type);
        map.add("cityCode", String.valueOf(cityCode));
        map.add("nodeId", nodeId);
        map.add("routeId", routeId);
        return map;
    }
}
