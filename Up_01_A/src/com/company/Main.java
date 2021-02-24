package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Door> doors = new ArrayList<>();
        Door door1 = new Door("Red");
        door1.close();
        doors.add(door1);
        Door door2 = new Door("Green");
        doors.add(door2);
        ArrayList<Window> windows = new ArrayList<>();
        Window window1 = new Window(WindowState.OPEN, WindowType.SQUARE);
        Window window2 = new Window(WindowState.CLOSED, WindowType.SQUARE);
        windows.add(window1);
        windows.add(window2);
        Door entranceDoor = new Door("Brown");
        House house = new House(entranceDoor, doors, windows);
        house.closeWithKey();
        System.out.println(house.toString());
    }
}
