package com.company;

public class Student extends Pupil{
    private Integer course;
    public Student(String surname, String educationalInstitution, double institutionRating, double averageScore, int course) {
        super(surname, educationalInstitution, institutionRating, averageScore);
        this.course = course;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        if (super.equals(obj) && this.course.equals(student.getCourse())){
            return true;
        }
        return false;
    }
}
