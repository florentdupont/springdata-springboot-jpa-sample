package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.transaction.Transactional;
import java.util.Arrays;

@SpringBootApplication
@Transactional

public class DemoApplication implements CommandLineRunner {

	@Autowired
	UserRepository repo;

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {

		for(String name : applicationContext.getBeanDefinitionNames()) {
			Object o = applicationContext.getBean(name);
			System.out.println(name + " : " + o.getClass());
		}

		User u = new User("a", "b");
		repo.save(u);
	}


}
