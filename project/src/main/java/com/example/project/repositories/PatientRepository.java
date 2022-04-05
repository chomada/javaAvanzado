package com.example.project.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.project.entities.Patient;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient,Integer> {
	
	public List<Patient> findAll();
	
	public Patient findByFullName (String fullName);

}
