package hu.nje.naplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "hu.nje")
public class NaploApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaploApplication.class, args);
	}

}
