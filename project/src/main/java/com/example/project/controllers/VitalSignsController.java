package com.example.project.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.project.dto.VitalSignDTO;
import com.example.project.entities.Patient;
import com.example.project.entities.VitalSign;
import com.example.project.repositories.VitalSignRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vitalSigns")
public class VitalSignsController {

	@Autowired
	private VitalSignRepository vitalSignsRepository;
	
	@GetMapping
	List<VitalSignDTO> vitalSignList(){
		return vitalSignsRepository.findAll().stream().map(VitalSignDTO::new).collect(Collectors.toList());
	}
	
	@GetMapping("/patient")
	List<VitalSignDTO> vitalSignByPatient(@RequestBody Patient patient){
		return vitalSignsRepository.findByPatient(patient).stream().map(VitalSignDTO::new).collect(Collectors.toList());
	}
	
	@PutMapping("/patient/updateVitalSigns/{vitalSignId}")
	List<VitalSignDTO> updateVitalSigns(@RequestBody VitalSign vitalSign, @PathVariable Integer vitalSignId){
		VitalSign vitalSignOk= vitalSignsRepository.findById(vitalSignId).orElse(null);
		if(vitalSignOk!=null) {
			vitalSignOk.setVitalSignName(vitalSign.getVitalSignName());
			vitalSignOk.setValue(vitalSign.getValue());
			vitalSignOk= vitalSignsRepository.save(vitalSignOk);
			return vitalSignOk.getPatient().getVitalSigns().stream().map(VitalSignDTO::new).collect(Collectors.toList());
		}
		return null;
	}
	
	@DeleteMapping("/patient/borrarVitalSign/{vitalSignId}")
	void deleteVitalSign(@PathVariable Integer vitalSignId) {
		VitalSign vitalSignOk=vitalSignsRepository.findById(vitalSignId).orElse(null);
		if(vitalSignOk!=null)
				vitalSignsRepository.deleteById(vitalSignId);
	}
	
}