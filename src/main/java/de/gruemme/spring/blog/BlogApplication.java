package de.gruemme.spring.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starting point of your Spring Boot application.
 * 
 * @author <a href="mailto:gruemme@math.tu-berlin.de">Christian Gruemme</a>
 */
@SpringBootApplication
@Slf4j
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
