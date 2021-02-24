package com.company.CalcStrategy;

import com.company.Gems.Gem;

import java.util.List;

public class CalcWeight implements Calc{
    @Override
    public double calc(List<Gem> list) {
        double result = 0.0;
        for (Gem gem : list){
            result += gem.getWeight();
        }
        return result;
    }
}
