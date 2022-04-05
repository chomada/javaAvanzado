package com.example.project.entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="patients")

public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name= "name")
	private String fullName;
	
	@Column (name="birthday")
	private Date birthday;
	@OneToMany(mappedBy ="patient", cascade = CascadeType.ALL)
	private List<VitalSign> vitalSigns;
	
	public Patient() {
		
	}
	

	public Patient(Integer id, String fullName, Date birthday, List<VitalSign> vitalSigns) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.birthday = birthday;
		this.vitalSigns = vitalSigns;
	}

	public void addVitalSign(VitalSign vitalSign) {
		if (this.vitalSigns==null) {
			this.vitalSigns=new ArrayList<>();
		}
		this.vitalSigns.add(vitalSign);
		vitalSign.setPatient(this);
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
