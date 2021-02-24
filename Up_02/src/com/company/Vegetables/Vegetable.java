package com.company.Vegetables;

public abstract class Vegetable {
    protected String name;
    protected Double proteins;
    protected Double carbohydrates;
    protected Double calorieContent;
    protected VegetableState state;

    public Vegetable(String name, double proteins, double carbohydrates, double calorieContent) {
        this.name = name;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.calorieContent = calorieContent;
        this.state = VegetableState.FRESH;
    }

    public void setState(VegetableState state) {
        this.state = state;
    }

    public Double getCalorieContent() {
        return calorieContent;
    }

    public Double getProteins() {
        return proteins;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    @Override
    public String toString() {
        return this.name + " Количество белков: " + this.proteins + " Количество углеводов: " + this.carbohydrates +
                " Калорийность: " + this.calorieContent + " Состояние: " + this.state + '\n';
    }
}
