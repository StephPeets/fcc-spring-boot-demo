package com.example.demo.student;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
	public List<Student> getStudents(){
		return List.of(
			new Student(
			1L,
			"Janet",
			"janet@email.com",
			LocalDate.of(1990, Month.APRIL,5),
			32
			)
		);
	}
}
