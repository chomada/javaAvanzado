package com.example.demo.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="tbl_flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="number")
	private Integer number;
	
	@Size(min = 3, max = 20)
	@Column(name="model")
	private String model;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="destination")
	private String destination ;
	
	@ManyToOne
	private Airplane airplane;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="id_passenger")
	private List<Passenger> passenger;
	
	public Flight() {
		
	}
	

	public Flight(Integer number, @Size(min = 3, max = 20) String model, String origin, String destination, Airplane airplane,
			List<Passenger> passenger) {
		super();
		this.number = number;
		this.model = model;
		this.origin = origin;
		this.destination = destination;
		this.passenger = passenger;
		this.airplane = airplane;
	}

	public Airplane getAirplane() {
		return airplane;
	}
	public void setAirplane(Airplane airplane) {
		this.airplane=airplane;
	}
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}






	
	
}
