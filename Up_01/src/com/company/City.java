package com.company;

import java.util.Objects;

public class City {
    private String cityName;
    private Integer cityPopulation;
    private Double cityArea;
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public City(String cityName, Double cityArea, Integer cityPopulation, String label){
        this.cityArea = cityArea;
        this.cityName = cityName;
        this.cityPopulation = cityPopulation;
        this.label = label;
    }
    public Double getCityArea() {
        return cityArea;
    }

    public void setCityArea(Double cityArea) {
        this.cityArea = cityArea;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityPopulation(Integer cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public String getCityName() {
        return cityName;
    }

    public Integer getCityPopulation() {
        return cityPopulation;
    }

    @Override
    public String toString() {
        return "Город: " + cityName + ", " +
                "Население: " + cityPopulation + "ч., " +
                "Площадь: " + cityArea + "км^2\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cityName);
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
        boolean isNameEquals = Objects.equals(this.cityName, city.cityName);
        boolean isAreaEquals = Objects.equals(this.cityArea, city.cityArea);
        boolean isPopulationEquals = Objects.equals(this.cityPopulation, city.cityPopulation);
        boolean isLabelEquals = Objects.equals(this.label, city.label);
        return isNameEquals && isAreaEquals && isPopulationEquals && isLabelEquals;
    }
}