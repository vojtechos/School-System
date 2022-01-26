package com.example.schoolsystemfx.model;

import java.util.List;

public class Student {

    private String firstName;
    private String surname;
    private String clazz;
    private List<Grade> gradeList;

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", clazz='" + clazz + '\'' +
                ", gradeList=" + gradeList +
                '}';
    }
}
