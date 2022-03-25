package com.example.demo.dataOpenApi.ApiDto.ResponseDto;

import lombok.Data;

@Data
public class ArriveBusItem {
    private String nodeid;
    private String nodenm;
    private String routeid;
    private int routeno;
    private String routetp;
    private int arrprevstationcnt;
    private String vehicletp;
    private int arrtime;
}
