package com.example.demo.dataOpenApi.ApiDto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NearBusStationItem {
	private int citycode;
	private Double gpslong;
	private Double gpslati;
	private String nodeid;
	private String nodenm;
	private int nodeno;

	public NearBusStationItem(int citycode, Double gpslong, Double gpslati, String nodeid, String nodenm, int nodeno) {
		this.citycode = citycode;
		this.gpslong = gpslong;
		this.gpslati = gpslati;
		this.nodeid = nodeid;
		this.nodenm = nodenm;
		this.nodeno = nodeno;
	}
}
