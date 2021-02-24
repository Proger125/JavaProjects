package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            Reader reader = new Reader(new File("res/Belarus.txt"));
            Country country = reader.readData();
            System.out.println(country.getPopulation());
            System.out.println(country.toString());
            System.out.println("Столица: ");
            System.out.println(country.getCapital());
            ArrayList<City> regionCenters = country.getRegionCities();
            System.out.println("Областные центры: ");
            for (City city: regionCenters){
                System.out.println(city);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect file name");
        }
    }
}
