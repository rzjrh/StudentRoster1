package com.RezaAk.web.StudentRuster1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RezaAk.web.StudentRuster1.models.ContactInfo;
import com.RezaAk.web.StudentRuster1.models.Student;
import com.RezaAk.web.StudentRuster1.repositories.ContactInfoRepository;
import com.RezaAk.web.StudentRuster1.repositories.StudentRepository;

@Service
public class ApiService {
	private final StudentRepository studentRepository;
	private final ContactInfoRepository contactInfoRepository;
	public ApiService(StudentRepository studentRepository, ContactInfoRepository contactInfoRepository) {
		this.studentRepository = studentRepository;
		this.contactInfoRepository = contactInfoRepository;
	}
// findAll
	public List<Student> allStudents(){
		return studentRepository.findAll();
	}
	public List<ContactInfo> allContactInfo(){
		return contactInfoRepository.findAll();
	}
// create
	public void createStudent(Student student) {
		studentRepository.save(student);
		System.out.println("successfully created student : "+student.getId());
	}
	public void createContactInfo(ContactInfo contact) {
		contactInfoRepository.save(contact);
	}
	public void createStudent(String firstName, String lastName, int age) {
		System.out.println("called create student");
		Student x = new Student(firstName,lastName,age);
		System.out.println("created : " + x );
		studentRepository.save(x);
		System.out.println("saved   : " + x);
	}
}