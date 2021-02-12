package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private final Scanner scanner;
    public Reader(File file) throws FileNotFoundException {
        this.scanner = new Scanner(file);
    }
    public Country readData(){
        String countryName = scanner.next();
        int regionAmount = scanner.nextInt();
        ArrayList<Region> regions = new ArrayList<>();
        for (int i = 0; i < regionAmount; i++){
            regions.add(readRegionData());
        }
        City capital = getCapital(regions);
        return new Country(countryName, capital, regions);
    }
    private Region readRegionData(){
        String regionName = scanner.next();
        int districtAmount = scanner.nextInt();
        ArrayList<District> districts = new ArrayList<>();
        for (int i = 0; i < districtAmount; i++){
            districts.add(readDistrictData());
        }
        City regionCenter = getRegionCenter(districts);
        return new Region(regionName, regionCenter, districts);
    }
    private District readDistrictData(){
        String districtName = scanner.next();
        int cityAmount = scanner.nextInt();
        ArrayList<City> cities = new ArrayList<>();
        for (int i = 0; i < cityAmount; i++){
            cities.add(readCityData());
        }
        City districtCenter = getDistrictCenter(cities);
        return new District(districtName, districtCenter, cities);
    }
    private City readCityData(){
        String cityName = scanner.next();
        int cityPopulation = scanner.nextInt();
        double cityArea = scanner.nextDouble();
        String label = scanner.next();
        return new City(cityName, cityArea, cityPopulation, label);
    }
    private City getDistrictCenter(ArrayList<City> cities){
        for (City city: cities){
            if (city.getLabel().contains("D")){
                return city;
            }
        }
        throw new IllegalArgumentException("There is no district center in this district");
    }
    private City getRegionCenter(ArrayList<District> districts){
        for (District district: districts){
            for (City city: district.getDistrictCities()){
                if (city.getLabel().contains("R")){
                    return city;
                }
            }
        }
        throw new IllegalArgumentException("There is no region center in this region");
    }
    private City getCapital(ArrayList<Region> regions){
        for (Region region : regions){
            for (District district: region.getRegionDistricts()){
                for (City city: district.getDistrictCities()){
                    if (city.getLabel().contains("C")){
                        return city;
                    }
                }
            }
        }
        throw new IllegalArgumentException("There is no capital in this country");
    }
}
