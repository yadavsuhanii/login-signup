package com.demo.StudentRegistration.exceptions;

public class StudentCannotAddLectureException extends RuntimeException{

    public StudentCannotAddLectureException () {
        super("Add lecture is failed");
    }
}

