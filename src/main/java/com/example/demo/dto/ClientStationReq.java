package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ClientStationReq {

    @NotNull
    private Double gpsLati; //가로 //x //36.3
    @NotNull
    private Double gpsLong; //세로 //y //127.3
}
