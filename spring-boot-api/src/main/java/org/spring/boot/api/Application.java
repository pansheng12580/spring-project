package org.spring.boot.api;

import org.spring.boot.api.util.LogUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application implements CommandLineRunner,HealthIndicator{
	
	public static void main(String[] args) throws Exception{
//		SpringApplication.run(Application.class, args);
		new SpringApplicationBuilder()
		.sources(Application.class)
		.run(args);
	}

	public void run(String... arg0) throws Exception {
		System.out.println("CommandLineRunner--->spring-boot-api start!");
		LogUtil.i(this.getClass(),"CommandLineRunner--->spring-boot-api start!");
	}

	@Override
	public Health health() {
		return Health.up().withDetail("hello", "world").build();
	}
}
