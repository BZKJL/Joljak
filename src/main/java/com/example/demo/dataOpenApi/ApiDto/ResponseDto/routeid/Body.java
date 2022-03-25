package com.example.demo.dataOpenApi.ApiDto.ResponseDto.routeid;

import lombok.Data;

@Data
public class Body{
	private int pageNo;
	private int totalCount;
	private Items items;
	private int numOfRows;
}
