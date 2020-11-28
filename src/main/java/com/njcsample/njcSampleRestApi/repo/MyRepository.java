package com.njcsample.njcSampleRestApi.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.njcsample.njcSampleRestApi.model.Employee;

@Repository
public class MyRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public String insertValues (Employee employee) {
		
		String sql = "insert into employee_details (employee_id, employee_name) values (?,?)";
		try {
			jdbcTemplate.update(sql, new Object[] {employee.getEmployeeId(), employee.getEmployeeName()});
		} catch(Exception e) {
			return "Failure";
		}
		return "Success";
		
	}


	public List<Employee> readValues() {
		
		List<Employee> employees = null;
		String sql = "select employee_id, employee_name from employee_details";
		RowMapper<Employee> rowmapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		try {
			 employees = jdbcTemplate.query(sql, rowmapper);
		} catch(Exception e) {
			return null;
		}
		
		return employees;
	}
}
