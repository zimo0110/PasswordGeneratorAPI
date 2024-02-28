package com.example.passwordGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PasswordGeneratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(PasswordGeneratorApplication.class, args);
	}
}
