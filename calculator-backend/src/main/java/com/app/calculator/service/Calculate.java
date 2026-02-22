package com.app.calculator.service;

import java.util.List;

import com.app.calculator.dto.CalcHistoryDto;
import com.app.calculator.dto.HIstoryDto;
import com.app.calculator.dto.ResultDto;
import com.app.calculator.exception.CalculateException;

import javax.script.ScriptException;

public interface Calculate {
	
	//public ResultDto calculation(String operation, Double elementOne, Double elementTwo) throws CalculateException;
	
	public List<CalcHistoryDto> getLatest10History();

	public double calculateMultiOps(String value) throws ScriptException;
	

}
