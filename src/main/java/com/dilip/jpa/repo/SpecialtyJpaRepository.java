package com.dilip.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dilip.jpa.model.Speciality;

public interface SpecialtyJpaRepository 
			extends JpaRepository<Speciality, Long>, SpecialtyRepositoryCustom {
	
	//@Query("select specialty_name from Specialty")
	//List<String> findAllSpecialtyNames();
	
	@Query("SELECT s FROM Speciality s WHERE s.specialtyAbbr=?1")
	List<Speciality> findSpecialtyName(String specialtyAbbr);
}
