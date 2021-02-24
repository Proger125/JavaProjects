package com.company;

import com.company.Vegetables.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> vegetables;
    public Salad(){
        this.vegetables = new ArrayList<>();
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public void addVegetable(Vegetable vegetable){
        this.vegetables.add(vegetable);
    }
}
