package com.example.demo.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
public class GPSCoordinateReq {
    @NotNull
    private Double latitude; //가로 //x //36.3

    @NotNull
    private Double longitude; //세로 //y //127.3

}
