package com.company.CookingStrategies;

import com.company.Vegetables.Vegetable;
import com.company.Vegetables.VegetableState;

public class Frying implements Cooking{
    @Override
    public void cook(Vegetable vegetable) {
        vegetable.setState(VegetableState.FRIED);
    }
}
