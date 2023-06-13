package com.demo.StudentRegistration.service;

import com.demo.StudentRegistration.entity.Lecture;
import com.demo.StudentRegistration.entity.Student;
import com.demo.StudentRegistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository _studentRepository;

    public StudentService(){}

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this._studentRepository = studentRepository;
    }

    public List<Student> GetStudents(){
        return _studentRepository.findAll();
    }

    public Optional<Student> GetStudentById(int id){
        return _studentRepository.findById(id);
    }

    public Student InsertStudent(Student student){
        return _studentRepository.save(student);
    }

    public boolean UpdateStudent(Student student){
        Optional<Student> _student = GetStudentById(student.getId());
        if(_student.isPresent()){
            Student dbStudent = _student.get();
            dbStudent.setName(student.getName());
            dbStudent.setSurname(student.getSurname());
            dbStudent.setYear(student.getYear());
            _studentRepository.save(dbStudent);
            return true;
        }
        return false;
    }
}
