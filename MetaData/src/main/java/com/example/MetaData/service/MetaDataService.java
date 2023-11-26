package com.example.MetaData.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MetaData.dao.MetaDataRepository;
import com.example.MetaData.entity.MetaData;

@Service
public class MetaDataService {
	
	@Autowired
	private MetaDataRepository metaDataRepository;
	
	public List<MetaData> findAll(){
		return metaDataRepository.findAll();
	}

}
