package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Region {
    private String regionName;
    private City regionCenter;
    private Integer regionPopulation = 0;
    private Double regionArea = 0.0;
    private ArrayList<District> regionDistricts;

    public Region(String regionName, City regionCenter, ArrayList<District> regionDistricts){
        this.regionName = regionName;
        this.regionCenter = regionCenter;
        this.regionDistricts = new ArrayList<>();
        for(District district : regionDistricts){
            this.regionDistricts.add(district);
            this.regionArea += district.getDistrictArea();
            this.regionPopulation += district.getDistrictPopulation();
        }
    }
    public City getRegionCenter() {
        return regionCenter;
    }

    public void setRegionCenter(City regionCenter) {
        this.regionCenter = regionCenter;
    }

    public Integer getRegionPopulation() {
        return regionPopulation;
    }

    public void setRegionPopulation(Integer regionPopulation) {
        this.regionPopulation = regionPopulation;
    }

    public Double getRegionArea() {
        return regionArea;
    }

    public void setRegionArea(Double regionArea) {
        this.regionArea = regionArea;
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
        builder.append("Название области: ").append(regionName).append(", ");
        builder.append("Областной центр: ").append(regionCenter.getCityName()).append(", ");
        builder.append("Население области: ").append(regionPopulation).append(", ");
        builder.append("Площадь области: ").append(regionArea).append('\n');
        builder.append("Районы").append('\n');
        for(District district: regionDistricts){
            builder.append(district.toString());
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.regionName);
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
        boolean isNameEquals = Objects.equals(this.regionName, region.regionName);
        boolean isCenterEquals = Objects.equals(this.regionCenter, region.regionCenter);
        boolean isPopulationEquals = Objects.equals(this.regionPopulation, region.regionPopulation);
        boolean isAreaEquals = Objects.equals(this.regionArea, region.regionArea);
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
