package com.demo.StudentRegistration.controller;

import com.demo.StudentRegistration.entity.Lecture;
import com.demo.StudentRegistration.entity.Student;
import com.demo.StudentRegistration.entity.dto.StudentDTO;
import com.demo.StudentRegistration.exceptions.StudentNotFoundException;
import com.demo.StudentRegistration.exceptions.StudentsNotFoundException;
import com.demo.StudentRegistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService _studentService;

    public StudentController(){

    }

    @Autowired
    public StudentController(StudentService studentService){

        this._studentService = studentService;
    }

    @GetMapping(produces = "application/json")
    ResponseEntity<ArrayList<StudentDTO>> students() {
        List<Student> students = _studentService.GetStudents();
        if(students.size() == 0)
            throw new StudentsNotFoundException();
        ArrayList<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
        for(Student student : students){
            studentDTOList.add(ConvertEntityToDTO(student));
        }
        return ResponseEntity.ok(studentDTOList);
    }

    @GetMapping(path="/{id}", produces = "application/json")
    ResponseEntity<StudentDTO> findStudentById(@PathVariable("id") Integer id){
       Optional<Student> student = _studentService.GetStudentById(id);
        if(student.isPresent()){
            StudentDTO dto = ConvertEntityToDTO(student.get());
            return ResponseEntity.ok(dto);
        }else{
            throw new StudentNotFoundException(id);
        }
    }

    @PostMapping(consumes = "application/json")
    ResponseEntity<Student> insertStudent(@RequestBody StudentDTO studentDTO){
        Student studentEntity = ConvertDTOToEntity(studentDTO);
        Student stu = _studentService.InsertStudent(studentEntity);
        return ResponseEntity.ok(stu);
    }

    @PutMapping(path="/{id}", produces = "application/json")
    ResponseEntity<StudentDTO> updateStudent(@PathVariable("id") Integer id,
                                             @RequestBody StudentDTO studentDTO)
    {
        Student student = ConvertDTOToEntity(studentDTO);
        student.setId(id);
        boolean isSuccess = _studentService.UpdateStudent(student);
        if(isSuccess) {
            return ResponseEntity.ok(ConvertEntityToDTO(student));
        }else {
            throw new StudentNotFoundException(id);
        }
    }


    @GetMapping(path="/lectures/{id}", produces = "application/json")
    ResponseEntity<Set<Lecture>> listTakenLectures(@PathVariable("id") Integer id){

        Optional<Student> student = _studentService.GetStudentById(id);
        if(student.isPresent()){
            Student _student = student.get();
            return ResponseEntity.ok(_student.getLectures());
        }
        throw new StudentNotFoundException(id);
    }


    private Student ConvertDTOToEntity(StudentDTO dto){
        Student entity = new Student();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setYear(dto.getYear());
        return entity;
    }

    private StudentDTO ConvertEntityToDTO(Student entity){
        StudentDTO dto = new StudentDTO();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setYear(entity.getYear());
        return dto;
    }
}
