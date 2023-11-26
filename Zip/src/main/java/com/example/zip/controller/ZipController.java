package com.example.zip.controller;


import com.example.zip.service.ZipService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


@RestController
public class ZipController {

	@Autowired
	private ZipService zipService;

	@Autowired
	private KafkaConsumerConfig kafkaConsumerConfig;

	 @PostMapping("/extract-html-data")
	 public ResponseEntity<String> extractHtmlFile(@RequestParam("file") MultipartFile zipFile) throws IOException {

		 return zipService.extractHTML(zipFile);
	 }


}