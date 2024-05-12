package com.example.demo.dtos;

public class UniversityProgress {
    private String studentName;
    private String major;
    private double gpa;

    public UniversityProgress(String studentName, String major, double gpa) {
        this.studentName = studentName;
        this.major = major;
        this.gpa = gpa;
    }

    // Getters and setters
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}