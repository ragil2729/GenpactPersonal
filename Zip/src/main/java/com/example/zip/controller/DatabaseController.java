package com.example.zip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DatabaseController {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@GetMapping("/checkDbConnection")
	public String checkDbConnection() {
		
		try {
		jdbctemplate.queryForObject("Select 1", Integer.class);
		return"Database is successful";
		}catch(Exception ex) {
			return "Database is not successful" + ex.getMessage();
		}
		
	}

}
