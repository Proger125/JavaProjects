package com.company;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Series {
    private double firstElement;
    private int amountOfElements;
    private double denominator;

    public Series(double firstElement, int amountOfElements, double denominator){
        this.amountOfElements = amountOfElements;
        this.denominator = denominator;
        this.firstElement = firstElement;
    }
    public abstract double calculateJElement(int j);
    public double sumOfSeries(){
        double sum = firstElement;
        for (int i = 2; i < amountOfElements; i++){
            sum += calculateJElement(i);
        }
        return sum;
    }
    public String toString(){
        String result = String.valueOf(firstElement);
        for (int i = 2; i < amountOfElements; i++){
            double jElement = this.calculateJElement(i);
            result += String.valueOf(jElement);
        }
        return result;
    }
    public void SaveToFile(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(this.toString());
        writer.close();
    }
}
