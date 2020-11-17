package com.company.Series;

public class ExponentialSeries extends Series{
    public ExponentialSeries(){
        super();
    }
    public ExponentialSeries(double firstElement, int amountOfElements, double denominator) {
        super(firstElement, amountOfElements, denominator);
    }

    @Override
    public double calculateJElement(int j) throws IllegalArgumentException{
        if (j < 2){
            throw new IllegalArgumentException("Index should be more then 1");
        }
        return firstElement * Math.pow(denominator, j - 1);
    }

    @Override
    public double sumOfSeries() {
        return firstElement * (Math.pow(denominator, amountOfElements) - 1) / (denominator - 1);
    }
}
