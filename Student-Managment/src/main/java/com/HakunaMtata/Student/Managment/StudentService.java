package com.HakunaMtata.Student.Managment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentService {

    @Autowired // Autowiring the StudentRepository bean, means Spring will inject the StudentRepository instance here
    StudentRepository studentRepository; // Injecting the StudentRepository dependency

    public String addStudent(Student student) { // Method to add a student
        return studentRepository.addStudent(student); //
    }

    // Method to get a student by admission number
    public Student getStudent(int admissionNo) { // Method to get a student by admission number
        return studentRepository.getStudent(admissionNo); // Calling the repository method to get the student
    }
    // Method to update a student's age
    public String updateStudent(int admissionNo, int age) { // Method to update a student's age
        return studentRepository.updateStudent(admissionNo, age); // Calling the repository method to update the student
    }
    // Method to delete a student by admission number
    public String deleteStudent(int admissionNo) { // Method to delete a student by admission number
        return studentRepository.deleteStudent(admissionNo); // Calling the repository method to delete the student
    }

    // Method to get all students
    public Map<Integer, Student> getAllStudents() { // Method to get all students
        return studentRepository.db; // Returning the database (map) of students
    }
}
