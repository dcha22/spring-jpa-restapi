package com.dilip.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dilip.jpa.model.Hospital;

public interface HospitalJpaRepository extends JpaRepository<Hospital, Long> {

}
