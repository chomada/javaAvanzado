package com.coderhouse.desafio1.java;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JavaApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
	
        jdbcTemplate.execute("DROP TABLE IF EXISTS MOVIE");
        jdbcTemplate.execute("DROP TABLE IF EXISTS CATEGORY ");
        jdbcTemplate.execute("DROP TABLE IF EXISTS ACTOR");
       
        String sql="CREATE TABLE person(id serial NOT NULL, name varchar NULL, "+"age INTEGER NULL, CONSTRAINT person_pkey PRIMARY KEY(id));";
		
		String sqlMovie = "CREATE TABLE MOVIE(id serial NOT NULL, nombre varchar NULL, " +
                " fecha_estreno DATE, categoria_id Integer, CONSTRAINT pelicula_pkey PRIMARY KEY(id))";

        String sqlCategory = "CREATE TABLE CATEGORY(id serial NOT NULL, nombre varchar NULL, CONSTRAINT categorias_pkey PRIMARY KEY(id))";
        
        String sqlActor = "CREATE TABLE ACTOR(id serial NOT NULL, nombre varchar NULL, fecha_nacimiento DATE NULL, CONSTRAINT actores_pkey PRIMARY KEY(id))";

	
		
		int rows2 = jdbcTemplate.update(sqlMovie);

		int rows3 = jdbcTemplate.update(sqlCategory);

		int rows4 = jdbcTemplate.update(sqlActor);

		if(rows2>0) {
			System.out.println("Tabla MOVIE creada con exito");
		}
		if(rows3>0) {
			System.out.println("Tabla CATEGORY creada con exito");
		}
		if(rows4>0) {
			System.out.println("Tabla ACTOR creada con exito");
		}
		
        String insertCategory1=" INSERT INTO CATEGORY VALUES(1,'Thriller')";
        String insertCategory2=" INSERT INTO CATEGORY VALUES(2,'Action')";
        String insertCategory3=" INSERT INTO CATEGORY VALUES(3,'Fantasy')";
        jdbcTemplate.execute(insertCategory1);
        jdbcTemplate.execute(insertCategory2);
        jdbcTemplate.execute(insertCategory3);

        // INSERTAMOS PELICULAS
        String insertMovie1=" INSERT INTO MOVIE VALUES(1,'The spacejack','2003-3-22',1 )";
        String insertMovie2=" INSERT INTO MOVIE VALUES(2,'Star Wars','1970-03-20' ,2)";
        String insertMovie3=" INSERT INTO MOVIE VALUES(3,'The notebook','2020-12-12',3 )";
        jdbcTemplate.execute(insertMovie1);
        jdbcTemplate.execute(insertMovie2);
        jdbcTemplate.execute(insertMovie3);

        // INSERTAMOS ACTORES
        String insertActor1=" INSERT INTO ACTOR VALUES(1,'Robert Pattinson','1977-02-10')";
        String insertActor2=" INSERT INTO ACTOR VALUES(2,'John Rei','1987-02-24')";
        String insertActor3=" INSERT INTO ACTOR VALUES(3,'Matt Damon','1990-02-11')";
        jdbcTemplate.execute(insertActor1);
        jdbcTemplate.execute(insertActor2);
        jdbcTemplate.execute(insertActor3);


	}
		
}
