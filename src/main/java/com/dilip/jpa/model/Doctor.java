package com.dilip.jpa.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@JsonSerialize
public class Doctor {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JsonAlias(value = "hospitals")
	private List<Hospital> hospitalList;
	
	
	public Doctor(String name, List<Hospital> hospitalList) {
		this.name = name;
		this.hospitalList = hospitalList;
	}
}
