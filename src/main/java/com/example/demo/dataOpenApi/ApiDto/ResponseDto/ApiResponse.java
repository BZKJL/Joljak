package com.example.demo.dataOpenApi.ApiDto.ResponseDto;

import lombok.Data;

@Data
public class ApiResponse<T>{
	private ApiResponse response;
	private ApiHeader header;
	private ApiBody<T> body;
}
