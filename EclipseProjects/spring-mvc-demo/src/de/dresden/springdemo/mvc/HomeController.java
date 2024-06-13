package de.dresden.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {
	@RequestMapping("/index")
	public String welcome() {
		return "index";
	}
	@RequestMapping("/showForm")
	public String showForm() {
		return "showForm";
	}
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		// read the request parameter from the HTML form
		String name = request.getParameter("studentName");
		// convert the data to all caps
		name = name.toUpperCase();
		// create the message
		String msg = "Yo! " + name;
		//add message to the model
		model.addAttribute("message", msg);
		return"helloworld";
	}
	@RequestMapping("/processFormVersionThree")
	public String letsShoutDude(@RequestParam("studentName")String name, Model model) {
		// convert name to all caps
		name = name.toUpperCase();
		// create message
		String msg = "Yo! " + name;
		// add message to the model
		model.addAttribute("message", msg);
		return "helloworld";
	}
}