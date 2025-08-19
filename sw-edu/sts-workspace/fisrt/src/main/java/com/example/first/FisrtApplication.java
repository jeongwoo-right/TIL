package com.example.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"di_spring", "springmvc"})
//@ComponentScan(basePackages = "springmvc")

@ComponentScan(basePackages = "jpa")   					//annotation이 붙은 클래스를 찾아와라 (@Component @Autowired @Service @Controller)
@EntityScan(basePackages = "jpa.entity")
@EnableJpaRepositories(basePackages = "jpa.repository")
public class FisrtApplication {
	public static void main(String[] args) {
		SpringApplication.run(FisrtApplication.class, args);
	}

}
