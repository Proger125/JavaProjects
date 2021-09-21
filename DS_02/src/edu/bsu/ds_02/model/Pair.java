package edu.bsu.ds_02.model;

public class Pair {
    private User male;
    private User female;
    private double compatibility;

    public Pair(User male, User female, double compatibility) {
        this.male = male;
        this.female = female;
        this.compatibility = compatibility;
    }

    public User getMale() {
        return male;
    }

    public User getFemale() {
        return female;
    }

    public double getCompatibility() {
        return compatibility;
    }
}
