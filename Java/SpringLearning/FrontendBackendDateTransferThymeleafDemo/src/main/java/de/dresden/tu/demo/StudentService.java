package de.dresden.tu.demo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class StudentService {
    private List<Student> studentList;

    public StudentService(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student){
        if(studentList.isEmpty()){
            student.setId("1");
            studentList.add(student);
        }
        else{student.setId(Integer.toString(studentList.stream().mapToInt(stu->Integer.parseInt(stu.getId())).max().orElseThrow(NoSuchElementException::new)+1));}
    }
}
