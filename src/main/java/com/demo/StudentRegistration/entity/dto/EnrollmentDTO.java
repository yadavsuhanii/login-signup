package com.demo.StudentRegistration.entity.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDTO {
    public int lectureId;
    public int studentId;

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public int getStudentId() {
        return studentId;
    }


}
