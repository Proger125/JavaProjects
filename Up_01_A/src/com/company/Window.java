package com.company;

import java.util.Objects;

public class Window {
    private WindowState state;
    private WindowType type;

    public Window(WindowState state, WindowType type) {
        this.state = state;
        this.type = type;
    }

    public WindowState getState() {
        return state;
    }

    public void setState(WindowState state) {
        this.state = state;
    }

    public WindowType getType() {
        return type;
    }

    public void setType(WindowType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.state) + Objects.hash(this.type);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Window window = (Window) obj;
        boolean isStateEquals = Objects.equals(this.state, window.state);
        boolean isTypeEquals = Objects.equals(this.type, window.type);
        return isStateEquals && isTypeEquals;
    }

    @Override
    public String toString() {
        return "Окно. Тип окна: " + this.type.getType() + ", Состояние окна: " + this.state.getState() + '\n';
    }
}
