package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class District extends AdministrativeUnit{
    private City districtCenter;

    private ArrayList<City> districtCities;

    public String getDistrictName() {
        return name;
    }

    public void setDistrictName(String districtName) {
        this.name = districtName;
    }

    public District(String districtName, City districtCenter, ArrayList<City> districtCities){
        super(districtName);
        this.districtCenter = districtCenter;
        this.districtCities = new ArrayList<>();
        for (City city: districtCities){
            this.population += city.getCityPopulation();
            this.area += city.getCityArea();
            this.districtCities.add(city);
        }
    }
    public City getDistrictCenter() {
        return districtCenter;
    }

    public void setDistrictCenter(City districtCenter) {
        this.districtCenter = districtCenter;
    }

    public Integer getDistrictPopulation() {
        return population;
    }

    public void setDistrictPopulation(Integer districtPopulation) {
        this.population = districtPopulation;
    }

    public Double getDistrictArea() {
        return area;
    }

    public void setDistrictArea(Double districtArea) {
        this.area = districtArea;
    }

    public ArrayList<City> getDistrictCities() {
        return districtCities;
    }

    public void setDistrictCities(ArrayList<City> districtCities) {
        this.districtCities = districtCities;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Район: ").append(name).append(", ");
        builder.append("Районный центр: ").append(districtCenter.getCityName()).append(", ");
        builder.append("Население района: ").append(population).append(", ");
        builder.append("Площадь района: ").append(area).append('\n');
        builder.append("Города: ").append('\n');
        for (City city: districtCities){
            builder.append(city.toString());
        }
        return builder.toString();
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
        District district = (District) obj;
        boolean isNameEquals = Objects.equals(this.name, district.name);
        boolean isCenterEquals = Objects.equals(this.districtCenter, district.districtCenter);
        boolean isPopulationEquals = Objects.equals(this.population, district.population);
        boolean isAreaEquals = Objects.equals(this.area, district.area);
        boolean isCitiesEquals = true;
        for (City city : this.districtCities){
            if (!district.districtCities.contains(city)){
                isCitiesEquals = false;
                break;
            }
        }
        return isAreaEquals && isCenterEquals && isCitiesEquals && isNameEquals && isPopulationEquals;
    }
}
