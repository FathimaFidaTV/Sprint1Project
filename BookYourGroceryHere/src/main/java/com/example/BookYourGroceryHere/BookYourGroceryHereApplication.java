package com.example.BookYourGroceryHere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BookYourGroceryHereApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookYourGroceryHereApplication.class, args);
	}

}
