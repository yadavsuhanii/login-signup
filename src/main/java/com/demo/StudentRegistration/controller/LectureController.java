package com.demo.StudentRegistration.controller;

import com.demo.StudentRegistration.entity.Lecture;
import com.demo.StudentRegistration.entity.Student;
import com.demo.StudentRegistration.entity.dto.LectureDTO;
import com.demo.StudentRegistration.exceptions.LectureNotFoundException;
import com.demo.StudentRegistration.exceptions.LecturesNotFoundException;
import com.demo.StudentRegistration.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/lectures")
public class LectureController {

    private LectureService _lectureService;

    public LectureController(){}

    @Autowired
    public LectureController(LectureService lectureService){
        this._lectureService = lectureService;
    }

    @GetMapping(produces = "application/json")
    ResponseEntity<ArrayList<LectureDTO>> lectures() {
        List<Lecture> lectures = _lectureService.GetLectures();
        if(lectures.size() == 0)
            throw new LecturesNotFoundException();
        ArrayList<LectureDTO> lectureDTOList = new ArrayList<LectureDTO>();
        for(Lecture lecture : lectures){
            lectureDTOList.add(ConvertEntityToDTO(lecture));
        }
        return ResponseEntity.ok(lectureDTOList);
    }

    @GetMapping(path="/{id}", produces = "application/json")
    ResponseEntity<LectureDTO> findLectureById(@PathVariable("id") Integer id){
        Optional<Lecture> lecture = _lectureService.GetLectureById(id);
        if(lecture.isPresent()){
            LectureDTO dto = ConvertEntityToDTO(lecture.get());
            return ResponseEntity.ok(dto);
        }else{
            throw new LectureNotFoundException(id);
        }
    }

    @PostMapping(consumes = "application/json")
    ResponseEntity<Lecture> insertLecture(@RequestBody LectureDTO lectureDTO){
        Lecture lectureEntity = ConvertDTOToEntity(lectureDTO);
        Lecture lecture = _lectureService.InsertLecture(lectureEntity);
        return ResponseEntity.ok(lecture);
    }

    @PutMapping(path="/{id}", produces = "application/json")
    ResponseEntity<LectureDTO> updateLecture(@PathVariable("id") Integer id,
                                          @RequestBody LectureDTO lectureDTO)
    {
        Lecture lecture = ConvertDTOToEntity(lectureDTO);
        lecture.setId(id);
        boolean isSuccess = _lectureService.UpdateLecture(lecture);
        if(isSuccess) {
            return ResponseEntity.ok(ConvertEntityToDTO(lecture));
        }else {
            throw new LectureNotFoundException(id);
        }
    }

    @GetMapping(path="/students/{id}", produces = "application/json")
    ResponseEntity<Set<Student>> listEnrolledStudents(@PathVariable("id") Integer id){
        Optional<Lecture> lecture = _lectureService.GetLectureById(id);
        if(lecture.isPresent()){
            Lecture _lecture = lecture.get();
            return ResponseEntity.ok(_lecture.getStudents());
        }
        throw new LectureNotFoundException(id);
    }


    private Lecture ConvertDTOToEntity(LectureDTO dto){
        Lecture entity = new Lecture();
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setInstructor(dto.getInstructor());
        entity.setQuota(dto.getQuota());
        entity.setStudentsEnrolled(dto.getStudentsEnrolled());
        return entity;
    }

    private LectureDTO ConvertEntityToDTO(Lecture entity){
        LectureDTO dto = new LectureDTO();
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setInstructor(entity.getInstructor());
        dto.setQuota(entity.getQuota());
        dto.setStudentsEnrolled(entity.getStudentsEnrolled());
        return dto;
    }
}
