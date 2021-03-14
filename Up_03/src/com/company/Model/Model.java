package com.company.Model;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Model {
    private Map<Country, String> map;
    public Model(){
        map = new HashMap<>();
    }
    public DefaultListModel<ListCountry> convertToDefaultListModel() throws IOException {
        DefaultListModel<ListCountry> result = new DefaultListModel<>();
        for (var element : this.map.entrySet()){
            result.addElement(new ListCountry(element.getKey(), element.getValue()));
        }
        return result;
    }
    public void addElement(Country country, String capital){
        map.put(country, capital);
    }
}
