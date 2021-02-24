package com.company;

import com.company.CookingStrategies.Boiling;
import com.company.CookingStrategies.Cooking;
import com.company.CookingStrategies.Frying;
import com.company.CookingStrategies.Stewing;
import com.company.SortingStrategies.Sorting;
import com.company.SortingStrategies.SortingByCalories;
import com.company.SortingStrategies.SortingByCarbohydrates;
import com.company.SortingStrategies.SortingByProteins;
import com.company.Vegetables.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Chef {
    private Cooking cookingStrategy;
    private Sorting sortingStrategy;

    public void setCookingStrategy(Cooking strategy) {
        this.cookingStrategy = strategy;
    }

    public void setSortingStrategy(Sorting sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void cookVegetable(Vegetable vegetable){
        cookingStrategy.cook(vegetable);
    }
    private List<Vegetable> sortSalad(Salad salad){
        List<Vegetable> list = salad.getVegetables();
        sortingStrategy.sort(list);
        return list;
    }
    public Salad makeSalad(Recipe recipe){
        Salad salad = new Salad();
        for (Map.Entry<Vegetable, String> item : recipe.getIngredients().entrySet()){
            if (item.getValue().equals("Жарить")){
                this.setCookingStrategy(new Frying());
            }
            if (item.getValue().equals("Варить")){
                this.setCookingStrategy(new Boiling());
            }
            if (item.getValue().equals("Тушить")){
                this.setCookingStrategy(new Stewing());
            }
            Vegetable vegetable = item.getKey();
            cookVegetable(vegetable);
            salad.addVegetable(vegetable);
        }
        return salad;
    }
    public double calcCalorieContent(Salad salad){
        double calorieContent = 0.0;
        for (Vegetable vegetable : salad.getVegetables()){
            calorieContent += vegetable.getCalorieContent();
        }
        return calorieContent;
    }
    public List<Vegetable> sortVegetables(Salad salad, String param){
        if (param.equals("Белки")){
            this.setSortingStrategy(new SortingByProteins());
        }
        if (param.equals("Углеводы")){
            this.setSortingStrategy(new SortingByCarbohydrates());
        }
        if (param.equals("Калории")){
            this.setSortingStrategy(new SortingByCalories());
        }
        return sortSalad(salad);
    }
    public List<Vegetable> findVegetablesByCriteria(Salad salad, double lowBound, double highBound){
        List<Vegetable> result = new ArrayList<>();
        for (Vegetable vegetable : salad.getVegetables()){
            if (vegetable.getCalorieContent() > lowBound && vegetable.getCalorieContent() < highBound){
                result.add(vegetable);
            }
        }
        return result;
    }
}
