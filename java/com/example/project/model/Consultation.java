package com.example.project.model;

public class Consultation {

    private int conID;
    private String conTime;
    private String conDesc;
    private Student stuID;
    private Lecturer lecID;
    private String conStatus;

    public Consultation() {
    }

    public Consultation(int conID, String conTime, String conDesc, Student stuID, Lecturer lecID, String conStatus) {
        this.conID = conID;
        this.conTime = conTime;
        this.conDesc = conDesc;
        this.stuID = stuID;
        this.lecID = lecID;
        this.conStatus = conStatus;
    }

    public int getConID() {
        return conID;
    }

    public void setConID(int conID) {
        this.conID = conID;
    }

    public String getConTime() {
        return conTime;
    }

    public void setConTime(String conTime) {
        this.conTime = conTime;
    }

    public String getConDesc() {
        return conDesc;
    }

    public void setConDesc(String conDesc) {
        this.conDesc = conDesc;
    }

    public Student getStuID() {
        return stuID;
    }

    public void setStuID(Student stuID) {
        this.stuID = stuID;
    }

    public Lecturer getLecID() {
        return lecID;
    }

    public void setLecID(Lecturer lectID) {
        this.lecID = lectID;
    }

    public String getConStatus() {
        return conStatus;
    }

    public void setConStatus(String conStatus) {
        this.conStatus = conStatus;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "conID=" + conID +
                ", conTime='" + conTime + '\'' +
                ", conDesc='" + conDesc + '\'' +
                ", stuID='" + stuID + '\'' +
                ", lecID='" + lecID  + '\'' +
                ", conStatus='" + conStatus + '\'' +
                '}';
    }
}