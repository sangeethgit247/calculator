package com.app.calculator.repository;

import java.util.List;

import com.app.calculator.entity.CalcHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.calculator.entity.History;

@Repository
public interface CalculatorRepository extends JpaRepository<CalcHistory, Long>{
	
	List<CalcHistory> findTop10ByOrderByIdDesc();
	

}
