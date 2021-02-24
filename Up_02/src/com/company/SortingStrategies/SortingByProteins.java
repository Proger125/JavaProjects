package com.company.SortingStrategies;

import com.company.Vegetables.Vegetable;

import java.util.List;

public class SortingByProteins implements Sorting{
    @Override
    public void sort(List<Vegetable> list) {
        list.sort((a,b) ->{
            return a.getProteins().compareTo(b.getProteins());
        });
    }
}
