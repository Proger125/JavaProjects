package com.company;

public class ProgrammingLanguage {
    private String name;
    private Double popularity;

    public ProgrammingLanguage(String name, Double popularity) {
        this.name = name;
        this.popularity = popularity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }
}
