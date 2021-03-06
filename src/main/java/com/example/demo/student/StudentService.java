package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository
		.findStudentByEmail(student.getEmail());
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("Email already registered.");
		}
		studentRepository.save(student);
	}

	@Transactional
	public void updateStudent(Long studentId,
	                          String studentName,
	                          String studentEmail) {
		Student student = studentRepository.findById(studentId).
		orElseThrow(() -> new IllegalStateException(
		"Student id #" + studentId + " does not exist"
		));

		if (studentName != null &&
		    studentName.length() > 0 &&
		    !Objects.equals(student.getName(), studentName)) {
			student.setName(studentName);
		}

		if (studentEmail != null &&
		    studentEmail.length() > 0 &&
		    !Objects.equals(student.getEmail(), studentEmail)) {
				Optional<Student> studentOptional = studentRepository
				.findStudentByEmail(studentEmail);
				if (studentOptional.isPresent()) {
					throw new IllegalStateException("Email already registered.");
			}
			student.setEmail(studentEmail);
		}

	}

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException(
			"Student id #" + studentId + " does not exist"
			);
		}
		studentRepository.deleteById(studentId);
	}
}

// 2. Method created automatically after alt+enter on addNewStudent
//	public void addNewStudent(Student student) {
//	}