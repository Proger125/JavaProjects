package com.company.SortingStrategies;

import com.company.Vegetables.Vegetable;

import java.util.List;

public class SortingByCalories implements Sorting{
    @Override
    public void sort(List<Vegetable> list) {
        list.sort((a, b) ->{
            return a.getCalorieContent().compareTo(b.getCalorieContent());
        });
    }
}
