package com.example.demo.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Data
public class ClientRouteIdRes {

    //private String routeid;
    private String beaconId;
    public ClientRouteIdRes(String beaconId) {

        this.beaconId = beaconId;
    }
}
