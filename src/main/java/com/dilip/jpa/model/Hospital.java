package com.dilip.jpa.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Hospital {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@JsonAlias(value = "hospital_name")
	private String hospitalName;
	private String location;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
}
