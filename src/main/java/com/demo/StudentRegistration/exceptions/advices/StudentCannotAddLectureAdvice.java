package com.demo.StudentRegistration.exceptions.advices;

import com.demo.StudentRegistration.exceptions.StudentCannotAddLectureException;
import com.demo.StudentRegistration.exceptions.StudentCannotDropLectureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentCannotAddLectureAdvice {
    @ResponseBody
    @ExceptionHandler(StudentCannotAddLectureException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String student(StudentCannotAddLectureException ex) {
        return ex.getMessage();
    }
}

