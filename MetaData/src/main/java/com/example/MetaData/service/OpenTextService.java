package com.example.MetaData.service;

import ch.qos.logback.core.CoreConstants;
import com.example.MetaData.dao.MetaDataRepository;
import com.example.MetaData.entity.MetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.MetaData.util.SSLUtil;
import org.json.JSONObject;

@Service
public class OpenTextService {
	
    @Autowired
    private MetaDataRepository metaDataRepository;

	public ResponseEntity<String> createFolder( String type, String name, String parent_id, String token) {

        SSLUtil.disableCertificateValidation();

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("type", type);
        map.add("name", name);
        map.add("parent_id", parent_id);

        String targetUrl = "https://otcs.g005-dev.opentext.cloud/cs/cs.exe/api/v1/nodes";

        RestTemplate  restTemplate = new RestTemplate();

        HttpHeaders   headers = new HttpHeaders();
        headers.set("OTCSTICKET",token);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.exchange(targetUrl, HttpMethod.POST, request, String.class);

        JSONObject jsonResponse = new JSONObject(response.getBody());
        int id = jsonResponse.getInt("id");
       
         MetaData metdata =new MetaData(); 
          metdata.setObjectID(id);
		  metdata.setFile_name(name);

      
        metaDataRepository.save(metdata);

        return response;

    }


	public ResponseEntity<String> generateToken(@RequestParam String username, @RequestParam String password) {

		  SSLUtil.disableCertificateValidation();

		    MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
	        map.add("username", username);
	        map.add("password", password);

	        HttpHeaders   headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

	        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);


		    String targetUrl = "https://otcs.g005-dev.opentext.cloud/cs/cs.exe/api/v1/auth";

	        RestTemplate  restTemplate = new RestTemplate();

           ResponseEntity<String> response = restTemplate.exchange(targetUrl, HttpMethod.POST, request, String.class);
      
         



	        return response;
	}




	public ResponseEntity<String> createDocument(String type, String name, String parent_id, String token,
			MultipartFile file) {


	    SSLUtil.disableCertificateValidation();

        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
        map.add("type", type);
        map.add("name", name);
        map.add("parent_id", parent_id);
        map.add("file", file.getResource());

        String targetUrl = "https://otcs.g005-dev.opentext.cloud/cs/cs.exe/api/v1/nodes";

        RestTemplate  restTemplate = new RestTemplate();


        HttpHeaders   headers = new HttpHeaders();
        headers.set("OTCSTICKET",token);
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.exchange(targetUrl, HttpMethod.POST, request, String.class);
        
        JSONObject jsonResponse = new JSONObject(response.getBody());
        int id = jsonResponse.getInt("id");
       
         MetaData metdata =new MetaData(); 
          metdata.setObjectID(id);
		    metdata.setFile_name(name);
		    
		    metaDataRepository.save(metdata);

        return response;
	}

}
