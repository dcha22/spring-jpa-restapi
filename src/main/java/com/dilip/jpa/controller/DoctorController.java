package com.dilip.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dilip.jpa.model.Doctor;
import com.dilip.jpa.model.EmptyJsonResponse;
import com.dilip.jpa.model.Hospital;
import com.dilip.jpa.model.OkJsonResponse;
import com.dilip.jpa.repo.DoctorJpaRepository;
import com.dilip.jpa.repo.HospitalJpaRepository;

@RestController
public class DoctorController {

	@Autowired
	DoctorJpaRepository doctorRepo;
	
	@Autowired
	HospitalJpaRepository hospitalRepo;
	
	
	@GetMapping("/greetings")
	public ResponseEntity greeting() {
		return new ResponseEntity<>("hello, greetings", HttpStatus.OK);
	}
	
	@GetMapping("/doctors")
	public <T> ResponseEntity<List<?>> getAllDoctors() {
	//public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> doctorsLst = doctorRepo.findAll();
		if(doctorsLst.isEmpty())
			return new ResponseEntity<List<?>>(doctorsLst, HttpStatus.OK);
		else 
			return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
	}
	
	@PostMapping("/doctor")
	public ResponseEntity<OkJsonResponse> addDoctor(@RequestBody Doctor doctor) throws Exception {
		List<Hospital> hospitalList = new ArrayList<>();
		
		for(Hospital hospital: doctor.getHospitalList()) {
			hospitalList.add(hospital);
		}
		
		Doctor _doctor = new Doctor(doctor.getName(), hospitalList);
		doctorRepo.save(_doctor);
		
		String status = "OK";
		return new ResponseEntity<>(new OkJsonResponse(status), HttpStatus.OK);
	}
}
