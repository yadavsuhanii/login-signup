package com.demo.StudentRegistration.entity.dto;


public class StudentDTO {
    private String name;
    private String surname;
    private int year;

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public int getYear(){
        return this.year;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setYear(int year){
        this.year = year;
    }
}
