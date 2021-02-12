package com.company;

public abstract class Pupil {
    private String surname;
    private String educationalInstitution;
    private Double institutionRating;
    private Double averageScore;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEducationalInstitution() {
        return educationalInstitution;
    }

    public void setEducationalInstitution(String educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }

    public Double getInstitutionRating() {
        return institutionRating;
    }

    public void setInstitutionRating(double institutionRating) {
        this.institutionRating = institutionRating;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public Pupil(String surname, String educationalInstitution, double institutionRating, double averageScore) {
        this.surname = surname;
        this.educationalInstitution = educationalInstitution;
        this.institutionRating = institutionRating;
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return surname + " " + educationalInstitution + " " + institutionRating + " " + averageScore;
    }

    @Override
    public boolean equals(Object obj) {
        Pupil pupil = (Pupil) obj;
        if (this.averageScore.equals(pupil.averageScore) && this.institutionRating.equals(pupil.institutionRating) &&
            this.educationalInstitution.equals(pupil.educationalInstitution) && pupil.surname.equals(pupil.surname)) {
            return true;
        }
        return false;
    }
}
