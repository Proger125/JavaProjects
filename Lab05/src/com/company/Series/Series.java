package com.company.Series;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Series {
    protected double firstElement;
    public void setFirstElement(double element){
        this.firstElement = element;
    }
    public double getFirstElement(){
        return firstElement;
    }
    protected int amountOfElements;
    public void setAmountOfElements(int element){
        this.amountOfElements = element;
    }
    public int getAmountOfElements(){
        return amountOfElements;
    }
    protected double denominator;
    public void setDenominator(double element){
        this.denominator = element;
    }
    public double getDenominator(){
        return denominator;
    }
    public Series(){
        this.denominator = 0;
        this.amountOfElements = 0;
        this.firstElement = 0;
    }
    public Series(double firstElement, int amountOfElements, double denominator){
        this.amountOfElements = amountOfElements;
        this.denominator = denominator;
        this.firstElement = firstElement;
    }
    public abstract double calculateJElement(int j);
    public double sumOfSeries(){
        double sum = firstElement;
        for (int i = 2; i <= amountOfElements; i++){
            sum += calculateJElement(i);
        }
        return sum;
    }
    public String toString(){
        String result = Double.toString(firstElement) + " ";
        for (int i = 2; i <= amountOfElements; i++){
            double jElement = this.calculateJElement(i);
            result = result.concat(Double.toString(jElement) + " ");
        }
        return result;
    }
    public void saveToFile(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(this.toString());
        writer.close();
    }
}
