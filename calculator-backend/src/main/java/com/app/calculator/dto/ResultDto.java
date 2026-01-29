package com.app.calculator.dto;

public class ResultDto {
	
	private String operationType;
	
	private double elementOne;
	
	private double elementTwo;
	
	private double result;
	
	public ResultDto() {
		// TODO Auto-generated constructor stub
	}

	public ResultDto(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public double getElementOne() {
		return elementOne;
	}

	public void setElementOne(double elementOne) {
		this.elementOne = elementOne;
	}

	public double getElementTwo() {
		return elementTwo;
	}

	public void setElementTwo(double elementTwo) {
		this.elementTwo = elementTwo;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	

}
