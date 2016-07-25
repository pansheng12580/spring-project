package org.spring.boot.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... arg0) throws Exception {
		System.out.println("spring-boot-api start!");
	}
}
