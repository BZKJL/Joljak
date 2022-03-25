package com.example.demo.dataOpenApi.ApiDto;

import com.example.demo.dto.ClientStationReq;
import lombok.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@AllArgsConstructor
public class GPSCoordinateReq {

        private int numOfRows = 10;
        private int pageNo = 1;
        private String _type = "json";
        private Double gpsLati ; //가로 //x //36.3
        private Double gpsLong ; //세로 //y //127.3

    public GPSCoordinateReq(ClientStationReq gps) {
        this.gpsLati = gps.getGpsLati();//가로 //x //36.3
        this.gpsLong = gps.getGpsLong(); //세로 //y //127.3
    }

    public MultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();
        map.add("gpsLati",String.valueOf(gpsLati));
        map.add("gpsLong",String.valueOf(gpsLong));
        map.add("numOfRows", String.valueOf(numOfRows));
        map.add("pageNo", String.valueOf(pageNo));
        map.add("_type", _type);
        return map;
    }
}
