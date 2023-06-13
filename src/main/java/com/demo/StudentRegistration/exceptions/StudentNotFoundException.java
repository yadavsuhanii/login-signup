package com.demo.StudentRegistration.exceptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException (Integer id) {
        super("Could not find student wrt student id: " + id);
    }
}

