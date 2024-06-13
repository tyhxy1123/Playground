package de.dresden.tu.demo;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonControlelr {
    private StudentService service;

    public JsonControlelr(StudentService service) {
        this.service = service;
    }

    @PostMapping("/jsonTest")
    public Student test(Student student){
        service.addStudent(student);
        System.out.println(student);
        return student;
    }
}
