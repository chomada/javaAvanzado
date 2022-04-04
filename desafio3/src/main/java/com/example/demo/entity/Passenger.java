package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="tbl_passenger")


public class Passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_passenger")
	private Integer id_passenger;
	
	@Size(min = 3, max = 20)
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	

	
	@ManyToOne
	private Flight flight;
	
	public Passenger() {
		
	}
	
	public Passenger(Integer id, String firstName, String lastName,Flight flight) {
		super();
		this.id_passenger = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.flight=flight;
	}
	public Integer getId() {
		return id_passenger;
	}

	public void setId(Integer id) {
		this.id_passenger = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight=flight;
	}

	

}
