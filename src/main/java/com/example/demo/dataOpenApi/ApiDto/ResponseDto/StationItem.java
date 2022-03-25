package com.example.demo.dataOpenApi.ApiDto.ResponseDto;

import lombok.Data;

@Data
public class StationItem {
    private double gpslong;
    private String nodenm;
    private double gpslati;
    private int nodeno;
    private String routeid;
    private int updowncd;
    private int nodeord;
    private String nodeid;
}
