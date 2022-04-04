package com.coderhouse.desafio4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

public class Desafio4Application {

	public static void main(String[] args) {
		SpringApplication.run(Desafio4Application.class, args);
	}

}
