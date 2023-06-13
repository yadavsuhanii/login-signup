package com.demo.StudentRegistration.exceptions.advices;

import com.demo.StudentRegistration.exceptions.LecturesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class LecturesNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(LecturesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String student(LecturesNotFoundException ex) {
        return ex.getMessage();
    }
}
