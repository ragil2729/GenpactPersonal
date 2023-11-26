package com.example.MetaData.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MetaData.entity.MetaData;
import com.example.MetaData.service.MetaDataService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MetaDataController {
	
	@Autowired
	private MetaDataService metadataservice;
	
	
	@GetMapping("/findAll")
	public List<MetaData> findAll(){
		return metadataservice.findAll();
		
	}
	
	

}
