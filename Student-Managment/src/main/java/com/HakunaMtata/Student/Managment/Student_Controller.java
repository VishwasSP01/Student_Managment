package com.HakunaMtata.Student.Managment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Student_Controller {
    Map< Integer, Student> db= new HashMap<>(); // act as a database


    // CRUD operations to create, read, update and delete student records

    //get student information by admission number
    @GetMapping("/getStudent/{admissionNo}") // @GetMapping is used to get the data from the client
    public ResponseEntity<?> getStudent(@PathVariable("admissionNo") int admissionNo){
        if(db.containsKey(admissionNo)){ // this @PathVariable is used to get the data from the URL just with the help of admission number
            return ResponseEntity.ok(db.get(admissionNo));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admission number "+admissionNo+" not found");
        }
    }

    //adding information that is adding student post API
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){ // @RequestBody is used to get the data from the client
        int admissionNo = student.getAdmissionNo();
        if (db.containsKey(admissionNo)) {
            return "Student with admission number " + admissionNo + " already exists.";
        } else {
            db.put(admissionNo, student);
            return "Student added successfully.";
        }
    }
    //updating student information
    public String updateStudent(@RequestBody Student student){
        int admissionNo = student.getAdmissionNo();// taking admission number as input through @RequestBody
        if (db.containsKey(admissionNo)) {
            db.put(admissionNo, student);// updating the student information
            return "Student updated successfully.";
        } else {
            return "Student with admission number " + admissionNo + " does not exist.";
        }
    }

    //deleting student information
    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("q") int admissionNo){
        if (db.containsKey(admissionNo)) {
            db.remove(admissionNo);
            return "Student with admission number " + admissionNo + " deleted successfully.";
        } else {
            return "Student with admission number " + admissionNo + " does not exist.";
        }
    }

    //getting all student information
    @GetMapping("/getAllStudents")
    public ResponseEntity<?> getAllStudents() {
        if (db.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No students found");
        } else {
            return ResponseEntity.ok(db.values());
        }
    }


}
