package com.company;

public enum DoorState {
    OPEN("Открыто"),
    CLOSED("Закрыто"),
    LOCKED("Закрыто на ключ");
    private String state;
    DoorState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
}
