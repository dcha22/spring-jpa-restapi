package com.dilip.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "specialty")
public class Speciality {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long specialtyId;
	private String specialtyAbbr;
	private String specialtyName;
}
