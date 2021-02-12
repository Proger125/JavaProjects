package com.company;

public class Schoolar extends Pupil{
    private Integer schoolarClass;
    private Behavior behavior;
    public Schoolar(String surname, String educationalInstitution, double institutionRating, double averageScore, int schoolarClass, Behavior behavior) {
        super(surname, educationalInstitution, institutionRating, averageScore);
        this.schoolarClass = schoolarClass;
        this.behavior = behavior;
    }

    public Integer getSchoolarClass() {
        return schoolarClass;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    @Override
    public boolean equals(Object obj) {
        Schoolar pupil = (Schoolar) obj;
        if (super.equals(obj) && this.behavior.equals(pupil.getBehavior()) && this.schoolarClass.equals(pupil.schoolarClass)){
            return true;
        }
        return false;
    }
}
