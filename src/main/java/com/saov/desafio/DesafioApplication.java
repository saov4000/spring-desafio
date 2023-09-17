package com.saov.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioApplication {
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}
}
