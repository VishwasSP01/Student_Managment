package com.HakunaMtata.Student.Managment;

public class Student {
    private String name;
    private String age;
    private int admissionNo;
    private String state;

    public Student(String name, String age, int admissionNo, String state) {
        this.name = name;
        this.age = age;
        this.admissionNo = admissionNo;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getAdmissionNo() {
        return admissionNo;
    }

    public void setAdmissionNo(int admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
