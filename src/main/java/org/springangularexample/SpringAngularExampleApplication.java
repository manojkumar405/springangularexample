package org.springangularexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * The Spring Boot Application Class
 * @author manojkumar.m
 *
 */
@SpringBootApplication
@EnableCaching
public class SpringAngularExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularExampleApplication.class, args);
	}

}
