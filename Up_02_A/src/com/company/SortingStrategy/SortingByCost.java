package com.company.SortingStrategy;

import com.company.Gems.Gem;

import java.util.List;

public class SortingByCost implements Sorting{
    @Override
    public void sort(List<Gem> list) {
        list.sort((a, b) -> {
           return a.getCost().compareTo(b.getCost());
        });
    }
}
