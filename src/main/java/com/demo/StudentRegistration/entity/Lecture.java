package com.demo.StudentRegistration.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;

//@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "code" }, callSuper = false)
@ToString(of = { "code" }, callSuper = true)
@Entity
@Table(name="LECTURES")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(name = "Code", length = 8, nullable = false)
    private String code;

    @Column(name = "Name", length = 64, nullable = false)
    private String name;

    @Column(name = "Instructor", length = 64, nullable = false)
    private String instructor;

    @Column(name = "Quota", length = 64, nullable = false)
    private int quota;

    @Column(name = "StudentsEnrolled", length = 64, nullable = false)
    private int studentsEnrolled;

    @ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "lectures_students" ,
            joinColumns = {@JoinColumn(name ="lecture_id")},
            inverseJoinColumns = {@JoinColumn(name="student_id")})

    private Set<Student> students = new HashSet<>();

    public String getInstructor() {
        return instructor;
    }

    public String getCode() {
        return code;
    }

    public int getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public int getQuota() {
        return quota;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Set<Student> getStudents() {
        return students;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public void setStudentsEnrolled(int studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean CanBeEnrolled(){
        return this.studentsEnrolled < this.quota;
    }

    public void incrementEnrolledCount() {this.studentsEnrolled += 1;}

    public void decrementEnrolledCount(){
        this.studentsEnrolled -= 1;
    }

}
