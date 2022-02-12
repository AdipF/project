package com.example.project.model;

public class Lecturer {

    int lecID;
    String lecName;
    String lecEmail;
    User id;

    public Lecturer() {
    }

    public Lecturer(int lecID, String lecName, String lecEmail, User id) {
        this.lecID = lecID;
        this.lecName = lecName;
        this.lecEmail = lecEmail;
        this.id = id;
    }

    public int getLecID() {
        return lecID;
    }

    public void setLecID(int lecID) {
        this.lecID = lecID;
    }

    public String getLecName() {
        return lecName;
    }

    public void setLecName(String lecName) {
        this.lecName = lecName;
    }

    public String getLecEmail() {
        return lecEmail;
    }

    public void setLecEmail(String lecEmail) {
        this.lecEmail = lecEmail;
    }

    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
    }
}
