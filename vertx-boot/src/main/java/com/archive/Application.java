package com.archive;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.vertx.core.Vertx;

@SpringBootApplication
public class Application {

	@Autowired
	private SimpleREST simpleREST;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Spring Boot application successully startd, but the rest is serverd by vertx.");
	}

	@PostConstruct
	public void deployVerticle() {
		Vertx.vertx().deployVerticle(simpleREST);
	}

}
