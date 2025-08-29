package com.example.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = "swaggertest")
@ComponentScan(basePackages = {"upload", "myconfig", "websocket"})  	 					//annotation이 붙은 클래스를 찾아와라 (@Component @Autowired @Service @Controller)
@EntityScan(basePackages = "jpa.entity")					// Entity annotation들을 찾아 주입한다.
@EnableJpaRepositories(basePackages = "jpa.repository")		// Repository 찾기
@EnableJpaAuditing
public class FisrtApplication {
	public static void main(String[] args) {
		SpringApplication.run(FisrtApplication.class, args);
	}

}
