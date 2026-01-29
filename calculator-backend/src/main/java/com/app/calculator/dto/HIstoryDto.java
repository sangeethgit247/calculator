package com.app.calculator.dto;

public class HIstoryDto {
	
	private Long id;
	
	private String operationType;
	
	private double elementOne;
	
	private double elementTwo;
	
	private double result;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "HIstoryDto [id=" + id + ", operationType=" + operationType + ", elementOne=" + elementOne
				+ ", elementTwo=" + elementTwo + ", result=" + result + "]";
	}
	
	

}
