package com.HakunaMtata.Student.Managment;

public class NoStudentsFoundException extends RuntimeException {
    public NoStudentsFoundException (String message) {
        super(message);
    }
}
