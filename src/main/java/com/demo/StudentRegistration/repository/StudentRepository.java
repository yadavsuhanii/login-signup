package com.demo.StudentRegistration.repository;

import com.demo.StudentRegistration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository <Student,Integer>  {
    Optional<Student> findById(int id);
    Student save(Student student);
}


