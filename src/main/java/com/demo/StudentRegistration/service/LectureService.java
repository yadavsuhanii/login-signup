package com.demo.StudentRegistration.service;

import com.demo.StudentRegistration.entity.Lecture;
import com.demo.StudentRegistration.entity.Student;
import com.demo.StudentRegistration.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectureService {

    private LectureRepository _lectureRepository;

    public LectureService(){}

    @Autowired
    public LectureService(LectureRepository lectureRepository){
        _lectureRepository = lectureRepository;
    }

    public List<Lecture> GetLectures(){
        return _lectureRepository.findAll();
    }

    public Optional<Lecture> GetLectureById(int id){
        return _lectureRepository.findById(id);
    }

    public Lecture InsertLecture(Lecture lecture){
        return _lectureRepository.save(lecture);
    }

   public boolean UpdateLecture(Lecture lecture){
        Optional<Lecture> _lecture = GetLectureById(lecture.getId());
        if(_lecture.isPresent()){
            Lecture dbLecture = _lecture.get();
            dbLecture.setStudentsEnrolled(lecture.getStudentsEnrolled());
            dbLecture.setQuota(lecture.getQuota());
            dbLecture.setInstructor(lecture.getInstructor());
            dbLecture.setCode(lecture.getCode());

            _lectureRepository.save(dbLecture);
             return true;
        }
        return false;
    }

    public void UpdateLectureEnrolledCount(Lecture lecture){
        Optional<Lecture> _lecture = GetLectureById(lecture.getId());
        if(_lecture.isPresent()){
            Lecture dbLecture = _lecture.get();
            dbLecture.setStudentsEnrolled(lecture.getStudentsEnrolled());
            _lectureRepository.save(dbLecture);
        }
    }
}
