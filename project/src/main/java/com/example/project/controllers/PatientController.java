package com.example.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.project.dto.PatientDTO;
import com.example.project.entities.Patient;
import com.example.project.entities.VitalSign;
import com.example.project.repositories.PatientRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping
	List<PatientDTO> patientList(){
		return patientRepository.findAll()
                .stream()
                .map(PatientDTO::new)
                .collect(Collectors.toList());
		
	}
	@GetMapping("findById/{patientId}")
	PatientDTO getPatientById(@PathVariable Integer patientId) {
		Patient wanted=patientRepository.findById(patientId).orElse(null);
		if (wanted!=null)
			return new PatientDTO(wanted);
		return null;
	}
	
	@GetMapping("/findByName/{patientName}")
	PatientDTO getPatientByName(@PathVariable String patientName) {
		Patient wanted =patientRepository.findByFullName(patientName);
		if (wanted!=null)
			return new PatientDTO(wanted);
		return null;
	}
	
	@PostMapping("/addPatient")
	PatientDTO addPatient(@RequestBody Patient newPatient) {
		newPatient.getVitalSigns().forEach(vitalSign ->{
			vitalSign.setPatient(newPatient);
		});
		return new PatientDTO(patientRepository.save(newPatient));
	}
	
	@PutMapping("/addVitalSignToPatient/{patientId}")
	PatientDTO addVitalSign(@PathVariable Integer patientId, @RequestBody VitalSign newVitalSign) {
		Patient patientUpdate = patientRepository.findById(patientId).orElse(null);
		if(patientUpdate!=null) {
			patientUpdate.addVitalSign(newVitalSign);
			return new PatientDTO(patientRepository.save(patientUpdate));
		}
		return null;
	}
	
	@PutMapping("/updatePatient/{patientId}")
	PatientDTO updatePatient(@PathVariable Integer patientId, @RequestBody Patient patientUpdate) {
		Patient patient =patientRepository.findById(patientId).orElse(null);
		if (patient!=null) {
			patient.setFullName(patientUpdate.getFullName());
			patient.setBirthday(patientUpdate.getBirthday());
			return new PatientDTO(patient);
		}
		return null;
	}
	
	@DeleteMapping("/deletePatient/{patientId}")
	void deletePatient(@PathVariable Integer patientId) {
		patientRepository.deleteById(patientId);
	}

}
