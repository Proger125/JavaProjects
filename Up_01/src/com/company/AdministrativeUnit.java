package com.company;

public abstract class AdministrativeUnit {
    protected String name;
    protected Integer population;
    protected Double area;

    public AdministrativeUnit(String name){
        this.name = name;
        this.population = 0;
        this.area = 0.0;
    }
    public AdministrativeUnit(String name, Integer population, Double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
