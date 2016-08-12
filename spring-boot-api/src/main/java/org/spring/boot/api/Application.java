package org.spring.boot.api;

import org.spring.boot.api.business.test.TestService;
import org.spring.boot.api.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class Application implements CommandLineRunner,HealthIndicator{
	@Autowired
	private TestService testService;
	
	public static void main(String[] args) throws Exception{
//		SpringApplication.run(Application.class, args);
		new SpringApplicationBuilder()
		.sources(Application.class)
		.run(args);
	}

	public void run(String... arg0) throws Exception {
		//此处可以初始化任务
		LogUtil.i(this.getClass(),"CommandLineRunner--->spring-boot-api start!");
		testService.test();
	}

	@Override
	public Health health() {
		return Health.up().withDetail("hello", "world").build();
	}
	
	@RequestMapping(value = "/")
	public String home(){
		return "redirect:countries";
	}
}
