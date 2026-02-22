package com.app.calculator.controller;

import java.util.List;
import java.util.Map;

import com.app.calculator.dto.CalcHistoryDto;
import com.app.calculator.dto.RequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.app.calculator.dto.ResultDto;
import com.app.calculator.exception.CalculateException;
import com.app.calculator.service.Calculate;

import jakarta.validation.constraints.Pattern;

import javax.script.ScriptException;

@RestController
@Validated
@RequestMapping("/math")
public class CalculatorController {
	
	private Calculate calcService;
	
	@Autowired
	public CalculatorController(Calculate calcService) {

		this.calcService = calcService;
	}
	
//	@PostMapping("/operation")
//	public ResponseEntity<ResultDto> getResult(@Valid @RequestBody RequestDto reqdto) throws CalculateException {
//
//		ResultDto dto = null;
//		//ResponseEntity<ResultDto> result = null;
//		if(reqdto == null){
//			throw new CalculateException("Please do an operation !");
//		}else{
//
//			String operation = reqdto.getOperationType();
//			Double elementOne = reqdto.getElementOne();
//			Double elementTwo = reqdto.getElementTwo();
//			dto = calcService.calculation(operation, elementOne, elementTwo);
//		}
//
//
//		return ResponseEntity.ok(dto);
//	}
	
	@GetMapping("/history")
	public ResponseEntity<List<CalcHistoryDto>> getHistory(){
		
		List<CalcHistoryDto> histories = null;
		
		histories = calcService.getLatest10History();
		
		return ResponseEntity.ok(histories);
	}

	@PostMapping("/operation")
	public double calculateMultipleOps(
			@RequestParam("expression") @Pattern(regexp = "^[0-9]+(?:\\s*[+\\-*/]\\s*[0-9]+)*$" ,
					message= "Invalid Input, please check the calculation") String expression) throws ScriptException {    //"7+5+8"

        return calcService.calculateMultiOps(expression);
	}

}
