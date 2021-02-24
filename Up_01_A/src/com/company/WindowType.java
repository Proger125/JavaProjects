package com.company;

public enum WindowType {
    CIRCLE("Круглое"),
    SQUARE("Квадратное"),
    RECTANGLE("Прямоугольное");
    private String type;
    WindowType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
