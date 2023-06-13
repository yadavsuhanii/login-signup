package com.demo.StudentRegistration.exceptions;

public class LecturesNotFoundException extends RuntimeException {

    public LecturesNotFoundException () {
        super("Could not find any lecture");
    }
}
