package com.company.Series;

public class LinearSeries extends Series{
    public LinearSeries(){
        super();
    }
    public LinearSeries(double firstElement, int amountOfElements, double denominator) {
        super(firstElement, amountOfElements, denominator);
    }

    @Override
    public double calculateJElement(int j) throws IllegalArgumentException{
        if (j < 2){
            throw new IllegalArgumentException("Index should be more then 1");
        }
        return firstElement + denominator * (j - 1);
    }
    @Override
    public double sumOfSeries(){
        double sum = (2 * firstElement + (amountOfElements - 1) * denominator) / 2 * amountOfElements;
        return sum;
    }
}
