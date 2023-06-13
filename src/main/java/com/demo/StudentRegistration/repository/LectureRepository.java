package com.demo.StudentRegistration.repository;

import com.demo.StudentRegistration.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LectureRepository extends JpaRepository <Lecture,Integer>  {
    Optional<Lecture> findById(int id);
    Lecture save(Lecture lecture);

}


