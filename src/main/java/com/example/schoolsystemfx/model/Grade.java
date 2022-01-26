package com.example.schoolsystemfx.model;

public class Grade {

    private int grade;
    private double weight;

    public Grade() {
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade=" + grade +
                ", weight=" + weight +
                '}';
    }
}
