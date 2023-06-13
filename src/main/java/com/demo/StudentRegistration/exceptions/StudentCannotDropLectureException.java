package com.demo.StudentRegistration.exceptions;

public class StudentCannotDropLectureException extends RuntimeException{

    public StudentCannotDropLectureException () {
        super("Drop lecture is failed");
    }
}
