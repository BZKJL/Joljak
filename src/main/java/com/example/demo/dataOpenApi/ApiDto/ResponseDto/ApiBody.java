package com.example.demo.dataOpenApi.ApiDto.ResponseDto;

import lombok.Data;

@Data
public class ApiBody<T> {
	private int pageNo;
	private int totalCount;
	private BodyItems<T> items;
	private int numOfRows;
}
