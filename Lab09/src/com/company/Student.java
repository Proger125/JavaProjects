package com.company;

public class Student{
    private int id;
    private String surname;
    private Integer course;
    private Integer group;
    private boolean isUnique;
    public Student(){}
    public Student(int id, String surname, int course, int group){
        this.id = id;
        this.surname = surname;
        this.course = course;
        this.group = group;
    }
    public boolean getUnique(){
        return isUnique;
    }
    public void setUnique(boolean isUnique){
        this.isUnique = isUnique;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return id + " " + surname + " Курс " + course + " Группа " + group;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

}
