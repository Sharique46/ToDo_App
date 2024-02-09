// Import necessary Spring Boot libraries
package com.todoproject.ToDo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotate the main class with SpringBootApplication annotation
@SpringBootApplication
public class ToDoApplication {

	// Main method to start the Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}

}
