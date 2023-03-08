package com.example.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Student Management System Spring Boot application.
 * This class uses the {@code @SpringBootApplication} annotation, which is a convenience
 * annotation that adds:
 * <ul>
 *     <li>{@code @Configuration}: Tags the class as a source of bean definitions for the application context.</li>
 *     <li>{@code @EnableAutoConfiguration}: Tells Spring Boot to start adding beans based on classpath settings,
 *         other beans, and various property settings. For example, if {@code spring-webmvc} is on the classpath,
 *         this flags the application as a web application and sets up a DispatcherServlet.</li>
 *     <li>{@code @ComponentScan}: Tells Spring to look for other components, configurations, and services
 *         in the {@code com.example.sms} package, allowing it to find controllers, services, repositories, etc.</li>
 * </ul>
 */
@SpringBootApplication
public class StudentManagementSystemApplication {

	/**
	 * The main method that starts the Spring Boot application.
	 *
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

}