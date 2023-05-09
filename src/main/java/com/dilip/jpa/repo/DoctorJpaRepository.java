package com.dilip.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dilip.jpa.model.Doctor;

public interface DoctorJpaRepository extends JpaRepository<Doctor, Long> {

}
