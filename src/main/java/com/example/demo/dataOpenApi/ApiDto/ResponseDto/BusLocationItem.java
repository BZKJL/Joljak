package com.example.demo.dataOpenApi.ApiDto.ResponseDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusLocationItem {

    private double gpslong;
    private String nodenm;
    private String vehicleno;
    private String routetp;
    private double gpslati;
    private int nodeord;
    private String nodeid;
    private int routenm;

}
