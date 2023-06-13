package com.demo.StudentRegistration.exceptions.advices;

import com.demo.StudentRegistration.exceptions.StudentCannotDropLectureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentCannotDropLectureAdvice {
    @ResponseBody
    @ExceptionHandler(StudentCannotDropLectureException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String student(StudentCannotDropLectureException ex) {
        return ex.getMessage();
    }
}
