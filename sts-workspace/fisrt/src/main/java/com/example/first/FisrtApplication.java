package com.example.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"di_spring", "springmvc"})
@ComponentScan(basePackages = "springmvc")
public class FisrtApplication {

	public static void main(String[] args) {
		SpringApplication.run(FisrtApplication.class, args);
	}

}
