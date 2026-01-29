package com.app.calculator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.calculator.entity.History;

@Repository
public interface CalculatorRepository extends JpaRepository<History, Long>{
	
	List<History> findTop10ByOrderByIdDesc();
	

}
