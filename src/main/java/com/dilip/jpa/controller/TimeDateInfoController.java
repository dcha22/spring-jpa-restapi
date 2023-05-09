package com.dilip.jpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilip.jpa.util.time.TimeDateClass;

@RestController
public class TimeDateInfoController {
	
	@GetMapping("/localtimenow")
	public ResponseEntity<String> getNow() {
		return new ResponseEntity<String>(TimeDateClass.getLocalDateTime().toString(), HttpStatus.OK);
	}
	
	@GetMapping("/epoch")
	public ResponseEntity<String> getEpoch() {
		return new ResponseEntity<String>(TimeDateClass.epochSecondsNow().toString(), HttpStatus.OK);
	}
	
	@GetMapping("/localnow") 
	public ResponseEntity<String> getLocalNOw() {
		return new ResponseEntity<String>(TimeDateClass.thisSec(), HttpStatus.OK);
	}
}
