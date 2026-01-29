package com.app.calculator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class History {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	
	
	

}
