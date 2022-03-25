package com.example.demo.dataOpenApi.ApiDto.ResponseDto;

import java.util.List;
import lombok.Data;

@Data
public class BodyItems<T> {
	private List<T> item;
}
