package com.example.restdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restdemo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	private List<Student> students;
	
	@PostConstruct 
	public void load() {
		this.students = new ArrayList<>();
		this.students.add(new Student("divy" , "Awasthi"));
		this.students.add(new Student("Mradul","Awasthi"));	
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return this.students;
	}
	
	@GetMapping("/students/{studentID}")
	public Student getStudent(@PathVariable int studentID) {
		if (studentID >= students.size() || studentID < 0) throw new StudentNotFoundException("Student id not found - " + studentID);
		return students.get(studentID);
	}
	
	
	
}
