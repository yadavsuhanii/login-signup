package com.demo.StudentRegistration.entity.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class LectureDTO {
    private String code;
    private String name;
    private String instructor;
    private int quota;
    private int studentsEnrolled;

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public void setStudentsEnrolled(int studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public String getName() {return name;}

    public int getQuota() {return quota;}

    public int getStudentsEnrolled() {return studentsEnrolled;}

    public String getCode() {return code;}

    public String getInstructor() {return instructor;}
}
