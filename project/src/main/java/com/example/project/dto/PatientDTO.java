package com.example.project.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.project.entities.Patient;
import com.example.project.entities.VitalSign;

public class PatientDTO {
	private Integer id;
    private String fullName;
    private Date birthday;
    private List<VitalSign> vitalSigns;
    
    public PatientDTO() {
    	
    }
    
    public PatientDTO(Patient patient) {
    	this.id=patient.getId();
    	this.fullName=patient.getFullName();
    	this.birthday=patient.getBirthday();
    	this.vitalSigns=new ArrayList<>();
    	patient.getVitalSigns().forEach(vitalSign-> this.vitalSigns.add(new VitalSign()));
    	
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<VitalSign> getVitalSigns() {
		return vitalSigns;
	}

	public void setVitalSigns(List<VitalSign> vitalSigns) {
		this.vitalSigns = vitalSigns;
	}
    
    


}
