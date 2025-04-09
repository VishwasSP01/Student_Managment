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
    
    // getting student information by admission number
    @GetMapping("/getStudent/{admissionNo}")
    public  ResponseEntity getStudent(@PathVariable int admissionNo) {
        Student student = studentService.getStudent(admissionNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND); // Returning the student object with HTTP status OK
    }

    // adding student information
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        String response = studentService.addStudent(student);;
        return new ResponseEntity<>(response, HttpStatus.CREATED).toString(); // Returning the response with HTTP status CREATED

    }

    // updating student information (age)
    @PutMapping("/updateStudent")
    public String updateStudent(@RequestParam int admissionNo, @RequestParam int age) {
        String response = studentService.updateStudent(admissionNo, age);
        return new ResponseEntity<>(response, HttpStatus.OK).toString(); // Returning the response with HTTP status OK
    }

    // deleting student information
    @DeleteMapping("/deleteStudent/{admissionNo}")
    public String deleteStudent(@PathVariable int admissionNo) {
        String response = studentService.deleteStudent(admissionNo);
        return new ResponseEntity<>(response, HttpStatus.GONE).toString(); // Returning the response with HTTP status OK
    }

    // getting all student information
    @GetMapping("/getAllStudents")
    public Map<Integer, Student> getAllStudents() {
        Map<Integer, Student> studends = studentService.getAllStudents();
        return new ResponseEntity<>(studends, HttpStatus.FOUND).getBody(); // Returning the map of students with HTTP status OK
    }


}