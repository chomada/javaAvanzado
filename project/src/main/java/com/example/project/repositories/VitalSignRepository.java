package com.example.project.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.project.entities.Patient;
import com.example.project.entities.VitalSign;

public interface VitalSignRepository extends CrudRepository<VitalSign, Integer>{
	
	public List<VitalSign> findAll();
	
	public List<VitalSign> findByPatient(Patient patient);
	

}
