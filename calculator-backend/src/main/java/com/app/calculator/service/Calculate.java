package com.app.calculator.service;

import java.util.List;

import com.app.calculator.dto.HIstoryDto;
import com.app.calculator.dto.ResultDto;
import com.app.calculator.exception.CalculateException;

public interface Calculate {
	
	public ResultDto calculation(String operation, double elementOne, double elementTwo) throws CalculateException;
	
	public List<ResultDto> getLatest10History();
	

}
