package com.dilip.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dilip.jpa.model.OkJsonResponse;
import com.dilip.jpa.model.Speciality;
import com.dilip.jpa.repo.SpecialtyJpaRepository;

@RestController
public class SpecialtyController {

	@Autowired
	SpecialtyJpaRepository specialtyJpaRepo;

	@GetMapping("/specialties")
	public ResponseEntity<List<Speciality>> getSpecialties() {
		return new ResponseEntity<>(specialtyJpaRepo.findAll(), HttpStatus.OK);
	}
	
	/*
	 * Get Specialty By Specialty Abbreviation
	 * 
	 */
	@GetMapping("/specialtybyabbr")
	public ResponseEntity<List<Speciality>> getSpecialtyNames(@RequestParam String specialtyAbbr) {
		return new ResponseEntity<>(specialtyJpaRepo.findSpecialtyName(specialtyAbbr), HttpStatus.OK);
	}
	
	/*
	 * Get all the Specialties (names only) from the database
	 * 
	 */
	@GetMapping("/specialtynames")
	public ResponseEntity<List<String>> getSpecialtyNames() {
		return new ResponseEntity<>(specialtyJpaRepo.getSpecialtyNames(), HttpStatus.OK);
	}

	@PostMapping("/specialties") 
	public ResponseEntity<OkJsonResponse> addSpecialties(@RequestBody List<Speciality> specialities) {
		List<Speciality> specialtyList = specialities;

		specialtyList.forEach(s ->specialtyJpaRepo.save(s));
		String status = "OK";
		return new ResponseEntity<>(new OkJsonResponse(status), HttpStatus.OK);
	}

	@PostMapping("/specialty") 
	public ResponseEntity<OkJsonResponse> addSpecialty(@RequestBody Speciality specialty) {
		specialtyJpaRepo.save(specialty);
		
		String status = "OK";
		return new ResponseEntity<>(new OkJsonResponse(status), HttpStatus.OK);
	}
}
