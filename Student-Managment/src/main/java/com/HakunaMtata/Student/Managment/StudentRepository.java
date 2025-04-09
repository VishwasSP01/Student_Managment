package com.HakunaMtata.Student.Managment;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {


    // act as a database
    Map<Integer, Student> db = new HashMap<>();

    //get student information by admission number
    public Student getStudent(int admissionNo) {
        return db.get(admissionNo);
    }

    // adding student information
    public String addStudent(Student student){
        int admissionNo = student.getAdmissionNo();
        db.put(admissionNo, student);
        return "Student added successfully.";
    }

    // updating student information (age)
    public String updateStudent(int admissionNo, int age) {
        if (!db.containsKey(admissionNo)) {
            return "Student with admission number " + admissionNo + " not found";
        }
        Student student = db.get(admissionNo);
        student.setAge(String.valueOf(age)); // Ensure setAge accepts int
        return "Student age updated successfully.";
    }

    // deleting student information
    public String deleteStudent(int admissionNo) {
        if (db.containsKey(admissionNo)) {
            db.remove(admissionNo);
            return "Student with admission number " + admissionNo + " deleted successfully.";
        } else {
            return "Student with admission number " + admissionNo + " does not exist.";
        }
    }



}
