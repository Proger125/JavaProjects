package com.company;

import com.company.Gems.Gem;
import com.company.SortingStrategy.*;
import com.company.CalcStrategy.*;

import java.util.ArrayList;
import java.util.List;

public class Jeweler {
    private Sorting sortingStrategy;
    private Calc calcStrategy;

    public void setSortingStrategy(Sorting sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setCalcStrategy(Calc calcStrategy) {
        this.calcStrategy = calcStrategy;
    }

    public Necklace makeNecklace(List<Gem> list){
        Necklace necklace = new Necklace();
        for (Gem gem : list){
            necklace.addGem(gem);
        }
        return necklace;
    }

    public List<Gem> sortGems(Necklace necklace, String param){
        if (param.equals("Вес")){
            this.setSortingStrategy(new SortingByWeight());
        }
        if (param.equals("Цена")){
            this.setSortingStrategy(new SortingByCost());
        }
        if (param.equals("Прозрачность")){
            this.setSortingStrategy(new SortingByTransparency());
        }
        return this.sortNecklace(necklace);
    }
    public double calcByParam(Necklace necklace, String param){
        if (param.equals("Цена")){
            this.setCalcStrategy(new CalcCost());
        }
        if (param.equals("Вес")){
            this.setCalcStrategy(new CalcWeight());
        }
        return calcStrategy.calc(necklace.getGems());
    }
    private List<Gem> sortNecklace(Necklace necklace){
        List<Gem> list = necklace.getGems();
        sortingStrategy.sort(list);
        return list;
    }
    public List<Gem> findGemsByParams(Necklace necklace, double low, double high){
        List<Gem> result = new ArrayList<>();
        for (Gem gem : necklace.getGems()){
            if (gem.getTransparency() > low && gem.getTransparency() < high){
                result.add(gem);
            }
        }
        return result;
    }
}
