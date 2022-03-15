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

import com.example.demo.entity.Flight;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.FlightRepository;



import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/api/flight")
@Validated
public class FlightRestController {
	@Autowired
	private FlightRepository flightRepository;
	
	@GetMapping("/{number}")
	@ResponseStatus(HttpStatus.OK)
	public Flight findById(@RequestHeader(name = "HEADER") String header, String query, @PathVariable Integer number) {
        return this.flightRepository.findById(number).orElseThrow(() -> new NotFoundException(number));
	}
	
		@GetMapping
	    @ResponseStatus(HttpStatus.OK)
	    public List<Flight> findAll() {
	        return  StreamSupport.stream(this.flightRepository.findAll().spliterator(), false)
	                .collect(Collectors.toList());
		}
	    
	
	 @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Flight createFlight (@Valid @RequestBody Flight flight) {
	        return this.flightRepository.save(flight);
	    }

	    @PutMapping("/{number}")
	    @ResponseStatus(HttpStatus.OK)
	    public Flight updateFlight(@PathVariable Integer number, @RequestBody Flight flight) {
	        flight.setNumber(number);
	        return this.flightRepository.save(flight);
	    }

	    @DeleteMapping("/{number}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void deleteFlight(@PathVariable Integer number) {
	        this.flightRepository.deleteById(number);
	    }
		
}
