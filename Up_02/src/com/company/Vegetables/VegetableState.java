package com.company.Vegetables;

public enum VegetableState {
    FRESH("Свежий"),
    FRIED("Жареный"),
    BOILED("Вареный"),
    STEWED("Тушеный");
    private String state;
    VegetableState(String state){
        this.state = state;
    }
    String getState(){
        return this.state;
    }
}
