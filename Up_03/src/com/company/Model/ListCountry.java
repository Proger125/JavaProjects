package com.company.Model;

public class ListCountry {
    Country country;
    String capital;
    public ListCountry(Country country, String capital){
        this.country = country;
        this.capital = capital;
    }

    public Country getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }
    public String getFlagPath(){
        return country.getFlagPath();
    }
    @Override
    public String toString() {
        return "Страна: " + this.getCountry().getName() + ". Столица: " + this.getCapital() + "\n";
    }
}
