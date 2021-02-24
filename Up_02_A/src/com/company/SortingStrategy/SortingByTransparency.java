package com.company.SortingStrategy;

import com.company.Gems.Gem;

import java.util.List;

public class SortingByTransparency implements Sorting{
    @Override
    public void sort(List<Gem> list) {
        list.sort((a, b) -> {
            return a.getTransparency().compareTo(b.getTransparency());
        });
    }
}
