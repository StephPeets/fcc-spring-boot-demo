package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository){
		return args -> {
			Student milroy = new Student(
				1L,
				"Milroy",
				"milroy@email.com",
				LocalDate.of(1990, JANUARY, 17),
				32
			);

			Student sarahlee = new Student(
			"Sarah Lee",
			"sarahlee@email.com",
			LocalDate.of(1979, DECEMBER, 5),
			42
			);


			repository.saveAll(
				List.of(milroy, sarahlee)
			);

		};
	}

}
