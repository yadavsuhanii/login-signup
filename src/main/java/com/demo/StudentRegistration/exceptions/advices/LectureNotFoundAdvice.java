package com.demo.StudentRegistration.exceptions.advices;

import com.demo.StudentRegistration.exceptions.LectureNotFoundException;
import com.demo.StudentRegistration.exceptions.LecturesNotFoundException;
import com.demo.StudentRegistration.exceptions.StudentsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class LectureNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(LectureNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String lecture(LectureNotFoundException ex) {
        return ex.getMessage();
    }
}

