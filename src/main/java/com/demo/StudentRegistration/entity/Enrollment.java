package com.demo.StudentRegistration.entity;

public class Enrollment {

    public int lectureId;

    public int studentId;

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getLectureId() {
        return lectureId;
    }
}

