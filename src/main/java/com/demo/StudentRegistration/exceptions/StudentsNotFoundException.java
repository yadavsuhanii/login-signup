package com.demo.StudentRegistration.exceptions;

public class StudentsNotFoundException extends RuntimeException {

    public StudentsNotFoundException () {
        super("Could not find any student");
    }
}
