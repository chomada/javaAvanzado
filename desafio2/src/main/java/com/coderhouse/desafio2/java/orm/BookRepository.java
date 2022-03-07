package com.coderhouse.desafio2.java.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query(value="SELECT p from Book p WHERE p.name<>name")
	List<Book> filtered(String name);
	
}