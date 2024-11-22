package com.learning.SpringBootLearning1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootLearning1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =	SpringApplication.run(SpringBootLearning1Application.class, args);
		
//		pehle scope singleton hone par contructor ek hi bar call ho rha tha
		Alien a = context.getBean(Alien.class);
		
		a.show();
//		ab scope lagane par jitne bar bhi get.bean call hoga utni barr constructor bhi call hoga
		Alien a1 = context.getBean(Alien.class);
				a1.show();
		
		
	}

}
