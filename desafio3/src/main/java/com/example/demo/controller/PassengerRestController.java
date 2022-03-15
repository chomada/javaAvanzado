package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Passenger;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.PassengerRepository;



import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/api/passenger")
@Validated
public class PassengerRestController {
	@Autowired
	private PassengerRepository passengerRepository;
	
	@GetMapping("/{passengerId}")
	@ResponseStatus(HttpStatus.OK)
	public Passenger findById(@RequestHeader(name = "HEADER") String header, String query, @PathVariable Integer passengerId) {
        return this.passengerRepository.findById(passengerId).orElseThrow(() -> new NotFoundException(passengerId));
	}
	
		@GetMapping
	    @ResponseStatus(HttpStatus.OK)
	    public List<Passenger> findAll() {
	        return  StreamSupport.stream(this.passengerRepository.findAll().spliterator(), false)
	                .collect(Collectors.toList());
		}
	    
	
	 @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Passenger createEmployee (@Valid @RequestBody Passenger passenger) {
	        return this.passengerRepository.save(passenger);
	    }

	    @PutMapping("/{passengerId}")
	    @ResponseStatus(HttpStatus.OK)
	    public Passenger updateEmployee(@PathVariable Integer passengerId, @RequestBody Passenger passenger) {
	        passenger.setId(passengerId);
	        return this.passengerRepository.save(passenger);
	    }

	    @DeleteMapping("/{passengerId}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void deleteEmployee(@PathVariable Integer passengerId) {
	        this.passengerRepository.deleteById(passengerId);
	    }
		
}
