package com.company;

import com.company.Gems.Gem;

import java.util.ArrayList;
import java.util.List;

public class Necklace {
    private List<Gem> gems;
    public Necklace(){
        gems = new ArrayList<>();
    }

    public List<Gem> getGems() {
        return gems;
    }
    public void addGem(Gem gem){
        this.gems.add(gem);
    }
}
