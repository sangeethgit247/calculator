package com.app.calculator.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.app.calculator.dto.CalcHistoryDto;
import com.app.calculator.entity.CalcHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.calculator.dto.HIstoryDto;
import com.app.calculator.dto.ResultDto;
import com.app.calculator.entity.History;
import com.app.calculator.exception.CalculateException;
import com.app.calculator.repository.CalculatorRepository;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Service
public class CalculatorServiceImpl implements Calculate{
	
	@Autowired
	private CalculatorRepository repo;
	
	public static final String ADDITION = "sum";
	public static final String SUBTRACTION = "minus";
	public static final String MULTIPLICATION = "multiply";
	public static final String DIVISION = "divide";
	
//	@Transactional
//	public ResultDto calculation(String operation, Double element1, Double element2) throws CalculateException {
//
//		ResultDto result = new ResultDto();
//		double resultOp =0;
//
//		if(operation.equalsIgnoreCase(ADDITION)) {
//			resultOp = element1 + element2;
//			setResultDto(result, operation, element1, element2);
//			result.setResult(resultOp);
//
//		}else if(operation.equalsIgnoreCase(SUBTRACTION)) {
//			resultOp = element1 - element2;
//			setResultDto(result, operation, element1, element2);
//			result.setResult(resultOp);
//
//		}else if(operation.equalsIgnoreCase(MULTIPLICATION)) {
//			resultOp = element1 * element2;
//			setResultDto(result, operation, element1, element2);
//			result.setResult(resultOp);
//
//		}else if(operation.equalsIgnoreCase(DIVISION)) {
//			resultOp = element1/element2;
//			setResultDto(result, operation, element1, element2);
//			result.setResult(resultOp);
//
//		}else {
//			throw new CalculateException("Invalid Operation !!");
//		}
//
//		if( !(null == result.getOperationType()) && !(result.getOperationType().isEmpty())) {
//
//			History history = new History();
//			history.setElementOne(result.getElementOne());
//			history.setElementTwo(result.getElementTwo());
//			history.setOperationType(result.getOperationType());
//			history.setResult(result.getResult());
//			repo.save(history);
//
//		}else {
//
//			throw new CalculateException("No Operations to Save!!");
//		}
//
//		return result;
//	}
//
//
//	private void setResultDto(ResultDto dto, String operation, double element1, double element2) {
//
//		dto.setOperationType(operation);
//		dto.setElementOne(element1);
//		dto.setElementTwo(element2);
//
//	}
	
	public List<CalcHistoryDto> getLatest10History(){
		
		List<CalcHistory> historyList = repo.findTop10ByOrderByIdDesc();
		
		List<CalcHistoryDto> resultList = new LinkedList<>();
		
		if(null != historyList && !historyList.isEmpty()) {
			
			for(CalcHistory history : historyList) {
				CalcHistoryDto dto = new CalcHistoryDto();
				dto.setId(history.getId());
				dto.setOperationString(history.getOperationString());
				dto.setResult(history.getResult());
				resultList.add(dto);
			}
		}
		
		return resultList;
	}

	@Override
	@Transactional
	public double calculateMultiOps(String value) throws ScriptException {

		value = value.replaceAll("\\s+", "");
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");

		Object resultObject = engine.eval(value);
		double result = Double.parseDouble(resultObject.toString());

		CalcHistory history = new CalcHistory();
		history.setOperationString(value);
		history.setResult(result);
		repo.save(history);

		return result;
	}

}
