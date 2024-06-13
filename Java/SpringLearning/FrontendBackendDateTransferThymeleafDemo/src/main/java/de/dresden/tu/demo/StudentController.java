package de.dresden.tu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class StudentController {
//    private List<Student> studentList;
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/addStudent")
    public String showStudentForm(@ModelAttribute Student student){
        return "addStudent";
    }
    @RequestMapping(value="/detail",method = RequestMethod.POST)
    @ResponseBody
    public Student detail(@ModelAttribute Student student){

        System.out.println(student);

        return student;
    }
    @GetMapping("/reach")
    public String reach(){
        return"reach";
    }

    @GetMapping("/testIndex")
    public String test(){
        return "jsonTest";
    }
}
