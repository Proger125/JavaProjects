package com.company.Gems;

public abstract class Gem {
    protected String name;
    protected Double weight;
    protected Double cost;
    protected Double transparency;
    public Gem(String name, double weight, double cost, double transparency){
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.transparency = transparency;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getCost() {
        return cost;
    }

    public Double getTransparency() {
        return transparency;
    }

    @Override
    public String toString() {
        return this.name + " Вес: " + this.weight + " Цена: " + this.cost + " Прозрачность: " + this.transparency + '\n';
    }
}
