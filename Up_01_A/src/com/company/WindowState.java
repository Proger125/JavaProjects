package com.company;

public enum WindowState {
    OPEN("Открыто"),
    CLOSED("Закрыто"),
    AERATION("На проветривании");
    private String state;
    WindowState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
}
