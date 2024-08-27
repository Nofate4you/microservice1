package com.kevin.school;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@EnableFeignClients
@SpringBootApplication
public class SchoolApplication {

	@Value("${application.config.students-url}")
	private String studentsUrl;

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

	@EventListener(ContextRefreshedEvent.class)
	public void logStudentsUrl() {
		System.out.println("Resolved students-url: " + studentsUrl);
	}
}
