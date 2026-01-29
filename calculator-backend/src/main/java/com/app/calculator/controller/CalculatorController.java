package com.app.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.calculator.dto.ResultDto;
import com.app.calculator.exception.CalculateException;
import com.app.calculator.service.Calculate;

import jakarta.validation.constraints.Pattern;

@RestController
@Validated
@RequestMapping("/math")
public class CalculatorController {
	
	private Calculate calcService;
	
	@Autowired
	public CalculatorController(Calculate calcService) {
		// TODO Auto-generated constructor stub
		this.calcService = calcService;
	}
	
	@PostMapping("/{operation}")
	public ResponseEntity<ResultDto> getResult(@PathVariable("operation") 
	@Pattern(regexp = "^(?:sum|minus|multiply|divide)$", message = "Choose the correct operation") String operation,
	@RequestParam("element1") double elementOne, @RequestParam("element2") double elementTwo) throws CalculateException {
		
		ResultDto dto = null;
		//ResponseEntity<ResultDto> result = null;
		
		dto = calcService.calculation(operation, elementOne, elementTwo);
		
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/history")
	public ResponseEntity<List<ResultDto>> getHistory(){
		
		List<ResultDto> histories = null;
		
		histories = calcService.getLatest10History();
		
		return ResponseEntity.ok(histories);
	}

}
