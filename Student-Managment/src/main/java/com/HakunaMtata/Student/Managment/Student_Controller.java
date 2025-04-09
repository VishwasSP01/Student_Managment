package com.HakunaMtata.Student.Managment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Student_Controller {

    @Autowired
    StudentService studentService; // Object of StudentService class is created
    

    @GetMapping("/getStudent/{admissionNo}")
    public  Student getStudent(@PathVariable int admissionNo) {
        return studentService.getStudent(admissionNo);
    }

    // adding student information
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // updating student information (age)
    @PutMapping("/updateStudent")
    public String updateStudent(@RequestParam int admissionNo, @RequestParam int age) {
        return studentService.updateStudent(admissionNo, age);
    }

    // deleting student information
    @DeleteMapping("/deleteStudent/{admissionNo}")
    public String deleteStudent(@PathVariable int admissionNo) {
        return studentService.deleteStudent(admissionNo);
    }

    // getting all student information
    @GetMapping("/getAllStudents")
    public Map<Integer, Student> getAllStudents() {
        return studentService.getAllStudents();
    }


}