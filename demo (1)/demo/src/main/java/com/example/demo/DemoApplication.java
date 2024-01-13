package com.example.demo;


import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
