package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Country {
    private String name;
    private City capital;
    private Integer population = 0;
    private Double area = 0.0;
    private ArrayList<Region> regions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country(String name, City capital, ArrayList<Region> regions){
        this.name = name;
        this.capital = capital;
        this.regions = new ArrayList<>();
        for (Region region : regions) {
            this.regions.add(region);
            this.area += region.getRegionArea();
            this.population += region.getRegionPopulation();
        }
    }
    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
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

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }
    public Integer getRegionsAmount(){
        return this.regions.size();
    }
    public ArrayList<City> getRegionCities(){
        ArrayList<City> cities = new ArrayList<>();
        for (int i = 0; i < regions.size(); i++){
            cities.add(regions.get(i).getRegionCenter());
        }
        return cities;
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
        Country country = (Country) obj;
        boolean isNameEquals = Objects.equals(this.name, country.name);
        boolean isCenterEquals = Objects.equals(this.capital, country.capital);
        boolean isPopulationEquals = Objects.equals(this.population, country.population);
        boolean isAreaEquals = Objects.equals(this.area, country.area);
        boolean isRegionEquals = this.regions.size() == country.regions.size();
        for (Region region : this.regions){
            if (!country.regions.contains(region)){
                isRegionEquals = false;
                break;
            }
        }
        return isAreaEquals && isCenterEquals && isRegionEquals && isNameEquals && isPopulationEquals;
    }
}
