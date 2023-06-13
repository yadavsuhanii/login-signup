package com.demo.StudentRegistration.exceptions.advices;

import com.demo.StudentRegistration.exceptions.StudentNotFoundException;
import com.demo.StudentRegistration.exceptions.StudentsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String student(StudentNotFoundException ex) {
        return ex.getMessage();
    }
}

