package com.demo.StudentRegistration.controller;

import com.demo.StudentRegistration.entity.Enrollment;
import com.demo.StudentRegistration.entity.Lecture;
import com.demo.StudentRegistration.entity.Student;
import com.demo.StudentRegistration.entity.dto.EnrollmentDTO;
import com.demo.StudentRegistration.entity.dto.StudentDTO;
import com.demo.StudentRegistration.exceptions.StudentCannotAddLectureException;
import com.demo.StudentRegistration.exceptions.StudentCannotDropLectureException;
import com.demo.StudentRegistration.repository.LectureRepository;
import com.demo.StudentRegistration.repository.StudentRepository;
import com.demo.StudentRegistration.service.EnrollmentService;
import com.demo.StudentRegistration.service.LectureService;
import com.demo.StudentRegistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    private LectureService _lectureService;
    private StudentService _studentService;
    private EnrollmentService _enrollmentService;

    public EnrollmentController(){}

    @Autowired
    public EnrollmentController(LectureService lectureService,
                                StudentService studentService,
                                EnrollmentService enrollmentService
    ){
        this._lectureService = lectureService;
        this._studentService = studentService;
        this._enrollmentService = enrollmentService;
    }

    @PostMapping(path="/add", consumes = "application/json")
    public void EnrollAStudent(@RequestBody EnrollmentDTO enrollmentDTO){
        //Lecture & Student Validation

        Optional<Lecture> lecture = GetLecture(enrollmentDTO.lectureId);
        if(!lecture.isPresent() || !lecture.get().CanBeEnrolled()){
            //Lecture is not available
            throw new StudentCannotAddLectureException();
        }

        Optional<Student> student = GetStudent(enrollmentDTO.studentId);

        if(!student.isPresent() || student.get().getLectures().contains(lecture.get())){
            //Student is not available
            throw new StudentCannotAddLectureException();
        }

        //Enroll
        Enrollment entity = ConvertDTOToEntity(enrollmentDTO);
        _enrollmentService.EnrollAStudent(entity);
    }

    @PostMapping(path="/drop", consumes = "application/json")
    public void DropAStudent(@RequestBody EnrollmentDTO enrollmentDTO){
        Optional<Lecture> lecture = GetLecture(enrollmentDTO.lectureId);
        if(!lecture.isPresent()){
            //Lecture is not available
            throw new StudentCannotDropLectureException();
        }

        Optional<Student> student = GetStudent(enrollmentDTO.studentId);

        if(!student.isPresent() || !student.get().getLectures().contains(lecture.get())){
            //Student is not available
            throw new StudentCannotDropLectureException();
        }

        //Drop
        Enrollment entity = ConvertDTOToEntity(enrollmentDTO);
        _enrollmentService.DropAStudent(entity);
    }

    private Optional<Lecture> GetLecture(int id){
        return _lectureService.GetLectureById(id);
    }

    private Optional<Student> GetStudent(int id){
        return _studentService.GetStudentById(id);
    }

    private Enrollment ConvertDTOToEntity(EnrollmentDTO dto){
        Enrollment entity = new Enrollment();
        entity.setLectureId(dto.getLectureId());
        entity.setStudentId(dto.getStudentId());
        return entity;
    }

    private EnrollmentDTO ConvertEntityToDTO(Enrollment entity){
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setLectureId(entity.getLectureId());
        dto.setStudentId(entity.getStudentId());
        return dto;
    }
}

