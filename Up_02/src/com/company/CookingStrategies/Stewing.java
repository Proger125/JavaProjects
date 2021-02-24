package com.company.CookingStrategies;

import com.company.Vegetables.Vegetable;
import com.company.Vegetables.VegetableState;

public class Stewing implements Cooking{
    @Override
    public void cook(Vegetable vegetable) {
        vegetable.setState(VegetableState.STEWED);
    }
}
