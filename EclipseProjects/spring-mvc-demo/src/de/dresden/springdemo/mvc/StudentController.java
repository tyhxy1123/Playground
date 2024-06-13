package de.dresden.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.dresden.springdemo.mvc.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		
		return "student-form";
	}
	
	
	@RequestMapping(value="/processForm",method=RequestMethod.POST)
	public String processForm(@ModelAttribute("student")Student student) {
		
		
		System.out.println(student);
		return "student-confirmation";
	}
}
