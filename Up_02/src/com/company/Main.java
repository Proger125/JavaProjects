package com.company;

import com.company.Vegetables.Cabbage;
import com.company.Vegetables.Carrot;
import com.company.Vegetables.Tomato;
import com.company.Vegetables.Vegetable;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Recipe recipe = new Recipe();
        recipe.addIngredient(new Cabbage(1.5, 5.2, 27.0), "Тушить");
        recipe.addIngredient(new Carrot(1.3, 7.6, 36.0), "Варить");
        recipe.addIngredient(new Tomato(0.5, 4.0, 18.0), "Жарить");
        Chef chef = new Chef();
        Salad salad = chef.makeSalad(recipe);
        for (Vegetable vegetable : salad.getVegetables()){
            System.out.println(vegetable);
        }
        List<Vegetable> list = chef.findVegetablesByCriteria(salad, 10.0, 30.0);
        for (Vegetable vegetable : list){
            System.out.println(vegetable);
        }
    }
}