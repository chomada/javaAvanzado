package com.example.demo.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="tbl_airplane")
public class Airplane {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patent")
	private Integer patent;
	
	@Size(min = 3, max = 20)
	@Column(name="model")
	private String model;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="airplane")
	private List<Flight> flight;
	
	
	
	
	public Airplane() {
		
	}



	public Airplane(Integer patent, @Size(min = 3, max = 20) String model, List<Flight> flight) {
		super();
		this.patent = patent;
		this.model = model;
		this.flight = flight;
	}





	public Integer getPatent() {
		return patent;
	}



	public void setPatent(Integer patent) {
		this.patent = patent;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public List<Flight> getFlight() {
		return flight;
	}



	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}



}
