package com.demo.StudentRegistration.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = { "name", "surname" }, callSuper = false)
@Entity
@Table(name="STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @Column(name = "Name", length = 64, nullable = false)
    private String name;

    @Column(name = "Surname", length = 64, nullable = false)
    private String surname;

    @Column(name = "Year", length = 64, nullable = false)
    private int year;


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "students")
    @JsonIgnore
    private Set<Lecture> lectures = new HashSet<>();

    public Student(){}

    public Student(String name, String surname, int year){
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    //Getter
    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }

    @Override
    public String toString() {
        return String.format("Student %d , Name: %s Surname: %s"
                ,this.id, this.name, this.surname);
    }
}
