package hello;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.vertx.core.Vertx;

@SpringBootApplication
public class Application {

	@Autowired
	private StaticServer staticServer;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Let's inspect the beans provided by Spring Boot:");
	}

	@PostConstruct
	public void deployVerticle() {
		Vertx.vertx().deployVerticle(staticServer);
	}

}
