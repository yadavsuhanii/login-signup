package com.demo.StudentRegistration.service;

import com.demo.StudentRegistration.entity.Enrollment;
import com.demo.StudentRegistration.entity.Lecture;
import com.demo.StudentRegistration.entity.Student;
import com.demo.StudentRegistration.repository.LectureRepository;
import com.demo.StudentRegistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    private LectureRepository _lectureRepository;
    private StudentRepository _studentRepository;

    public EnrollmentService(){}


    @Autowired
    public EnrollmentService(LectureRepository lectureRepository,
                             StudentRepository studentRepository){
        _lectureRepository = lectureRepository;
        _studentRepository = studentRepository;
    }
    public void EnrollAStudent(Enrollment enrollment){

    Lecture lecture = _lectureRepository.findById(enrollment.lectureId).get();
    Student student = _studentRepository.findById(enrollment.studentId).get();

    lecture.getStudents().add(student);
    lecture.incrementEnrolledCount();

    _lectureRepository.save(lecture);
    }

    public void DropAStudent(Enrollment enrollment){
        Lecture lecture = _lectureRepository.findById(enrollment.lectureId).get();
        Student student = _studentRepository.findById(enrollment.studentId).get();

        //student.getLectures().remove(lecture);
        lecture.getStudents().remove(student);
        lecture.decrementEnrolledCount();

        //_studentRepository.save(student);
        _lectureRepository.save(lecture);
    }
}

