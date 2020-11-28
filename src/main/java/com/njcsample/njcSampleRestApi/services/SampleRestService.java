package com.njcsample.njcSampleRestApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njcsample.njcSampleRestApi.model.Employee;
import com.njcsample.njcSampleRestApi.repo.MyRepository;

@RestController
@RequestMapping(value = "/sampleRestApi")
public class SampleRestService {
	
	@Autowired
	MyRepository repo;

	@PostMapping("/insertValues")
	public String insertValues(@RequestBody Employee employee) {
		
		if(employee != null && employee.getEmployeeId() != null && employee.getEmployeeName() !=null) {
			return repo.insertValues(employee);
		}
		
		else return "Please pass non empty values";
		
	}
	
	@PostMapping("/readValues")
	public ResponseEntity<Object> readValues() {
		List<Employee> employees =  repo.readValues();
		if(employees == null || employees.size() == 0) {
			return ResponseEntity.ok("No data available in the database");
		} else {
			return ResponseEntity.ok(employees);
		}
		
		
	}
}
