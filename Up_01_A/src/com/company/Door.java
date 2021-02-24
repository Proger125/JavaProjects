package com.company;

import java.util.Objects;

public class Door {
    private String color;
    private DoorState state;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public DoorState getState() {
        return state;
    }

    public void setState(DoorState state) {
        this.state = state;
    }

    public Door(String color) {
        this.color = color;
        this.state = DoorState.OPEN;
    }
    public void close(){
        this.state = DoorState.CLOSED;
    }
    public void closeWithKey(){
        this.state = DoorState.LOCKED;
    }
    public void open(){
        this.state = DoorState.OPEN;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.color) + Objects.hash(this.state);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Door door = (Door) obj;
        boolean isColorEquals = Objects.equals(this.color, door.color);
        boolean isStateEquals = Objects.equals(this.state, door.state);
        return isColorEquals && isStateEquals;
    }

    @Override
    public String toString() {
        return "Дверь. Цвет: " + this.color + ", Состояние: " + this.state.getState() + '\n';
    }
}
