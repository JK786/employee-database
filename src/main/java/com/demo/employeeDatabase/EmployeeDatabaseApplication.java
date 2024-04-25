package com.demo.employeeDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.demo" })
@SpringBootApplication
public class
EmployeeDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDatabaseApplication.class, args);
	}

}
