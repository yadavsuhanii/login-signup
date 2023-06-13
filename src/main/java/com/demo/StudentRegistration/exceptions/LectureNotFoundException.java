package com.demo.StudentRegistration.exceptions;

public class LectureNotFoundException extends RuntimeException {

    public LectureNotFoundException (Integer id) {
        super("Could not find lecture wrt lecture id: " + id);
    }
}

