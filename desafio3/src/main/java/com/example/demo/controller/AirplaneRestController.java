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

import com.example.demo.entity.Airplane;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.AirplaneRepository;



import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/api/airplane")
@Validated
public class AirplaneRestController {
	@Autowired
	private AirplaneRepository airplaneRepository;
	
	@GetMapping("/{number}")
	@ResponseStatus(HttpStatus.OK)
	public Airplane findById(@RequestHeader(name = "HEADER") String header, String query, @PathVariable Integer number) {
        return this.airplaneRepository.findById(number).orElseThrow(() -> new NotFoundException(number));
	}
	
		@GetMapping
	    @ResponseStatus(HttpStatus.OK)
	    public List<Airplane> findAll() {
	        return  StreamSupport.stream(this.airplaneRepository.findAll().spliterator(), false)
	                .collect(Collectors.toList());
		}
	    
	
	 @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Airplane createAirplane (@Valid @RequestBody Airplane airplane) {
	        return this.airplaneRepository.save(airplane);
	    }

	    @PutMapping("/{patent}")
	    @ResponseStatus(HttpStatus.OK)
	    public Airplane updateAirplane(@PathVariable Integer patent, @RequestBody Airplane airplane) {
	        airplane.setPatent(patent);
	        return this.airplaneRepository.save(airplane);
	    }

	    @DeleteMapping("/{patent}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void deleteAirplane(@PathVariable Integer patent) {
	        this.airplaneRepository.deleteById(patent);
	    }
		
}
