package com.company;

import com.company.Vegetables.Vegetable;

import java.util.HashMap;
import java.util.Map;

public class Recipe {

    private Map<Vegetable, String> ingredients;
    public Recipe(){
        this.ingredients = new HashMap<>();
    }
    public void addIngredient(Vegetable vegetable, String state){
        this.ingredients.put(vegetable, state);
    }
    public Map<Vegetable, String> getIngredients() {
        return ingredients;
    }
}
