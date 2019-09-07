package com.RezaAk.web.StudentRuster1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RezaAk.web.StudentRuster1.models.ContactInfo;
import com.RezaAk.web.StudentRuster1.models.Student;
import com.RezaAk.web.StudentRuster1.services.ApiService;

@Controller
public class MainController {
	private final ApiService apiService;
	public MainController(ApiService apiService) {
		this.apiService = apiService;
	}
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/students";
	}
	@RequestMapping("/students")
	public String index(Model model) {
		List<Student> students= apiService.allStudents();
		model.addAttribute("students",students);
		return "students";
	}
	@RequestMapping("/students/new")
	public String newstudent(@ModelAttribute("student") Student student) {
		return "newstudent";
	}
	@RequestMapping("/contact/new")
	public String newcontact(@ModelAttribute("contact") ContactInfo contact, Model model) {
		List<Student> students= apiService.allStudents();
		List<ContactInfo> allContact= apiService.allContactInfo();
		for(int i = 0; i<allContact.size(); i++){
			System.out.println("found info for : studentid:"+ allContact.get(i).getStudent().getId()+" removing from display list");			
			Student temp = allContact.get(i).getStudent();
			students.remove(temp);
		}
		model.addAttribute("students",students);
		return "newcontact";
	}

//~~~~~~Operations~~~~~~//

// create student
	@RequestMapping(value="/students/new", method=RequestMethod.POST)
	public String createstudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		System.out.println("hit route correctly");
		if(result.hasErrors()) {
			System.out.println("escaped due to errors");
			return "newstudent";			
		}
		System.out.println("creating student");
		apiService.createStudent(student);
		return "redirect:/students";
	}
//alt Route to create students via request param
	@RequestMapping(value="/students/alt/")
	public String newstudent(@RequestParam(value="firstName") String firstName,@RequestParam(value="lastName") String lastName ,@RequestParam(value="age") String age,RedirectAttributes ra) {
		if(firstName.equals("")) {
			ra.addFlashAttribute("fname_error", " - first name errors found");			
		}
		if(lastName.equals("")){
			ra.addFlashAttribute("lname_error", " - last name errors found");			
		}
		if(age.equals("")) {
			ra.addFlashAttribute("age_error", " - age must be greater than zero");			
		}
		if(ra.getFlashAttributes().size()>0){
			System.out.println("errors found.. escaping");
			return "redirect:/students/new";			
		}
		System.out.println("creating new student....");
		apiService.createStudent(firstName,lastName,Integer.parseInt(age));
		return "redirect:/students";
	}
// create student
@RequestMapping(value="/contact/new", method=RequestMethod.POST)
public String createstudent(@Valid @ModelAttribute("contact") ContactInfo contact, BindingResult result) {
	System.out.println("hit route correctly");
	if(result.hasErrors()) {
		System.out.println("escaped due to errors");
		return "newcontact";			
	}
	System.out.println("creating contact");
	apiService.createContactInfo(contact);
	return "redirect:/students";
}

}
