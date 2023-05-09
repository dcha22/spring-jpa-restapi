package com.dilip.jpa.repo;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class SpecialtyRepositoryCustomImpl implements SpecialtyRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getSpecialtyNames() {
		return em.createNativeQuery("SELECT specialty_name FROM Specialty").getResultList();
	}

}
