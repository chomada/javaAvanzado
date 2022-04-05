package com.example.project.dto;

import com.example.project.entities.VitalSign;

public class VitalSignDTO {
	
	private Integer id;
	private String vitalSignName;
	private Double value;
	
	public VitalSignDTO() {
		
	}
	public VitalSignDTO(VitalSign vitalSign) {
		this.id = vitalSign.getId();
        this.vitalSignName = vitalSign.getVitalSignName();
        this.value= vitalSign.getValue();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVitalSignName() {
		return vitalSignName;
	}
	public void setVitalSignName(String vitalSignName) {
		this.vitalSignName = vitalSignName;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}

}
