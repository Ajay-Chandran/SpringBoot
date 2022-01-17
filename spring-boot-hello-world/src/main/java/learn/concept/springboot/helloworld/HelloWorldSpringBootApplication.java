package learn.concept.springboot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldSpringBootApplication {

	public static void main(String[] args) {
		//SpringApplication.run(HelloWorldSpringBootApplication.class, args);
		SpringApplication app = new SpringApplication(HelloWorldSpringBootApplication.class);
		app.run(args);
	}

}
