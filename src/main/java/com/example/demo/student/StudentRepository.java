package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
	extends JpaRepository<Student, Long> {

}

// JPARepository adds a bunch of methods to StudentRepository similarly to CRUDRepository