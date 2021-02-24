package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class House {
    private Door entranceDoor;
    private ArrayList<Door> doors = new ArrayList<>();
    private ArrayList<Window> windows = new ArrayList<>();
    public House(Door entranceDoor, ArrayList<Door> doors, ArrayList<Window> windows){
        this.entranceDoor = entranceDoor;
        this.doors.addAll(doors);
        this.windows.addAll(windows);
    }
    public void close(){
        this.entranceDoor.close();
    }
    public void closeWithKey(){
        this.entranceDoor.closeWithKey();
    }
    public String getDoorsInfo(){
        StringBuilder builder = new StringBuilder();
        builder.append("Количество дверей: ").append(doors.size()).append('\n');
        for (Door door : doors){
            builder.append(door.toString());
        }
        return builder.toString();
    }
    public String getWindowsInfo(){
        StringBuilder builder = new StringBuilder();
        builder.append("Количество окон: ").append(windows.size()).append('\n');
        for (Window window : windows){
            builder.append(window.toString());
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(entranceDoor, doors, windows);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        House house = (House) obj;
        boolean isEntranceDoorEquals = Objects.equals(this.entranceDoor, house.entranceDoor);
        boolean isDoorsEquals = this.doors.size() == house.doors.size();
        for (Door door : house.doors){
            if (!this.doors.contains(door)){
                isDoorsEquals = false;
                break;
            }
        }
        boolean isWindowsEquals = this.windows.size() == house.windows.size();
        for (Window window : house.windows){
            if (!this.windows.contains(window)){
                isWindowsEquals = false;
                break;
            }
        }
        return isEntranceDoorEquals && isDoorsEquals && isWindowsEquals;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Входная " + entranceDoor.toString());
        builder.append("Двери: " + '\n');
        for (Door door : this.doors){
            builder.append(door.toString());
        }
        builder.append("Окна: " + '\n');
        for (Window window : windows){
            builder.append(window.toString());
        }
        return builder.toString();
    }
}
