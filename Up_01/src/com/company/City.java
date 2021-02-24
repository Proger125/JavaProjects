package com.company;

import java.util.Objects;

public class City extends AdministrativeUnit{
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public City(String cityName, Double cityArea, Integer cityPopulation, String label){
        super(cityName, cityPopulation, cityArea);
        this.label = label;
    }
    public Double getCityArea() {
        return super.getArea();
    }

    public void setCityArea(Double cityArea) {
        super.setArea(cityArea);
    }

    public void setCityName(String cityName) {
        super.setName(cityName);
    }

    public void setCityPopulation(Integer cityPopulation) {
        super.setPopulation(cityPopulation);
    }

    public String getCityName() {
        return super.getName();
    }

    public Integer getCityPopulation() {
        return super.getPopulation();
    }

    @Override
    public String toString() {
        return "Город: " + name + ", " +
                "Население: " + population + "ч., " +
                "Площадь: " + area + "км^2\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        City city = (City) obj;
        boolean isNameEquals = Objects.equals(this.name, city.name);
        boolean isAreaEquals = Objects.equals(this.area, city.area);
        boolean isPopulationEquals = Objects.equals(this.population, city.population);
        boolean isLabelEquals = Objects.equals(this.label, city.label);
        return isNameEquals && isAreaEquals && isPopulationEquals && isLabelEquals;
    }
}