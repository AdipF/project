package com.example.project.model;

public class Student {

    int stuID;
    String stuName;
    String stuEmail;
    User id;

    public Student() {
    }

    public Student(int stuID, String stuName, String stuEmail, User id) {
        this.stuID = stuID;
        this.stuName = stuName;
        this.stuEmail = stuEmail;
        this.id = id;
    }

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
    }
}
