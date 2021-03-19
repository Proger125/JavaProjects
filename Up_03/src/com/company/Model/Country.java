package com.company.Model;

public class Country {
    String name;
    String flagPath;
    public Country(String name, String flagPath){
        this.name = name;
        this.flagPath = flagPath;
    }

    public String getName() {
        return name;
    }

    public String getFlagPath() {
        return flagPath;
    }
}
