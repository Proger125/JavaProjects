package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Region extends AdministrativeUnit{
    private City regionCenter;
    private ArrayList<District> regionDistricts;

    public Region(String regionName, City regionCenter, ArrayList<District> regionDistricts){
        super(regionName);
        this.regionCenter = regionCenter;
        this.regionDistricts = new ArrayList<>();
        for(District district : regionDistricts){
            this.regionDistricts.add(district);
            this.area += district.getDistrictArea();
            this.population += district.getDistrictPopulation();
        }
    }
    public City getRegionCenter() {
        return regionCenter;
    }

    public void setRegionCenter(City regionCenter) {
        this.regionCenter = regionCenter;
    }

    public Integer getRegionPopulation() {
        return population;
    }

    public void setRegionPopulation(Integer regionPopulation) {
        this.population = regionPopulation;
    }

    public Double getRegionArea() {
        return area;
    }

    public void setRegionArea(Double regionArea) {
        this.area = regionArea;
    }

    public ArrayList<District> getRegionDistricts() {
        return regionDistricts;
    }

    public void setRegionDistricts(ArrayList<District> regionDistricts) {
        this.regionDistricts = regionDistricts;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Название области: ").append(name).append(", ");
        builder.append("Областной центр: ").append(regionCenter.getCityName()).append(", ");
        builder.append("Население области: ").append(population).append(", ");
        builder.append("Площадь области: ").append(area).append('\n');
        builder.append("Районы").append('\n');
        for(District district: regionDistricts){
            builder.append(district.toString());
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
        Region region = (Region) obj;
        boolean isNameEquals = Objects.equals(this.name, region.name);
        boolean isCenterEquals = Objects.equals(this.regionCenter, region.regionCenter);
        boolean isPopulationEquals = Objects.equals(this.population, region.population);
        boolean isAreaEquals = Objects.equals(this.area, region.area);
        boolean isDistrictEquals = this.regionDistricts.size() == region.regionDistricts.size();
        for (District district : this.regionDistricts){
            if (!region.regionDistricts.contains(district)){
                isDistrictEquals = false;
                break;
            }
        }
        return isAreaEquals && isCenterEquals && isDistrictEquals && isNameEquals && isPopulationEquals;
    }
}
