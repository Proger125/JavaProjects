package com.company;

import com.company.Gems.Diamond;
import com.company.Gems.Emerald;
import com.company.Gems.Gem;
import com.company.Gems.Ruby;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Gem> list = new ArrayList<>();
        list.add(new Emerald(9.0, 150000, 0.987));
        list.add(new Ruby(6.0, 100000.0, 0.7));
        list.add(new Diamond(3.0, 50000, 0.95));

        Jeweler jeweler = new Jeweler();
        Necklace necklace = jeweler.makeNecklace(list);
        Double generalCost = jeweler.calcByParam(necklace, "Цена");
        Double generalWeight = jeweler.calcByParam(necklace, "Вес");
        System.out.println(generalCost);
        System.out.println(generalWeight);
        List<Gem> list1 = jeweler.sortGems(necklace, "Вес");
        list1 = jeweler.findGemsByParams(necklace, 0.6, 0.8);
        for (Gem gem : list1){
            System.out.println(gem);
        }
    }
}
