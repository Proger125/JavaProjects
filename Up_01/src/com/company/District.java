package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class District {
    private String districtName;
    private City districtCenter;
    private Integer districtPopulation = 0;
    private Double districtArea = 0.0;
    private ArrayList<City> districtCities;

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public District(String districtName, City districtCenter, ArrayList<City> districtCities){
        this.districtName = districtName;
        this.districtCenter = districtCenter;
        this.districtCities = new ArrayList<>();
        for (City city: districtCities){
            this.districtPopulation += city.getCityPopulation();
            this.districtArea += city.getCityArea();
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
        return districtPopulation;
    }

    public void setDistrictPopulation(Integer districtPopulation) {
        this.districtPopulation = districtPopulation;
    }

    public Double getDistrictArea() {
        return districtArea;
    }

    public void setDistrictArea(Double districtArea) {
        this.districtArea = districtArea;
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
        builder.append("Район: ").append(districtName).append(", ");
        builder.append("Районный центр: ").append(districtCenter.getCityName()).append(", ");
        builder.append("Население района: ").append(districtPopulation).append(", ");
        builder.append("Площадь района: ").append(districtArea).append('\n');
        builder.append("Города: ").append('\n');
        for (City city: districtCities){
            builder.append(city.toString());
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.districtName);
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
        boolean isNameEquals = Objects.equals(this.districtName, district.districtName);
        boolean isCenterEquals = Objects.equals(this.districtCenter, district.districtCenter);
        boolean isPopulationEquals = Objects.equals(this.districtPopulation, district.districtPopulation);
        boolean isAreaEquals = Objects.equals(this.districtArea, district.districtArea);
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
