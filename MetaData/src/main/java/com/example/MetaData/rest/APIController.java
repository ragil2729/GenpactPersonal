package com.example.MetaData.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.MetaData.service.OpenTextService;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class APIController {
	

    @Autowired
    private OpenTextService openTextService;

    @PostMapping("/create-folder")
    public ResponseEntity<String> createFolder(@RequestParam String type, @RequestParam String name,@RequestParam String parent_id,
                                                  @RequestHeader("OTCSTICKET") String token) throws IOException {



       ResponseEntity<String> response= openTextService.createFolder(type,name,parent_id,token);
       

       if(response.getStatusCode()== HttpStatus.OK){
           return new ResponseEntity<>("Folder Created" +response.getBody(),HttpStatus.OK);
       }else{
           return new ResponseEntity<>("Folder Not Created",HttpStatus.NOT_FOUND);
       }
    }

    @PostMapping("/getToken")
    public ResponseEntity<String> getToken(@RequestParam String username, @RequestParam String password
                                                ) throws IOException {



       ResponseEntity<String> response= openTextService.generateToken(username,password);


       if(response.getStatusCode()== HttpStatus.OK){
           return new ResponseEntity<>("Token Created :"+ response.getBody(),HttpStatus.OK);
       }else{
           return new ResponseEntity<>("Token Not Created",HttpStatus.NOT_FOUND);
       }
    }

    @PostMapping("/create-document")
    public ResponseEntity<String> createDocument(@RequestParam String type, @RequestParam String name,@RequestParam String parent_id,
    		@RequestParam MultipartFile file, @RequestHeader("OTCSTICKET") String token) throws IOException {



       ResponseEntity<String> response= openTextService.createDocument(type,name,parent_id,token,file);

       if(response.getStatusCode()== HttpStatus.OK){
           return new ResponseEntity<>("Document Created" + response.getBody(),HttpStatus.OK);
       }else{
           return new ResponseEntity<>("Document Not Created",HttpStatus.NOT_FOUND);
       }
    }
	
}
