package com.company.CalcStrategy;

import com.company.Gems.Gem;

import java.util.List;

public class CalcCost implements Calc{
    @Override
    public double calc(List<Gem> list) {
        double result = 0.0;
        for (Gem gem : list){
            result += gem.getCost();
        }
        return result;
    }
}
