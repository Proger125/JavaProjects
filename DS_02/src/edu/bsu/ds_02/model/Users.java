package edu.bsu.ds_02.model;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Users implements Serializable {

    private List<User> males = new ArrayList<>();
    private List<User> females = new ArrayList<>();
    private List<Pair> pairs = new ArrayList<>();

    private int maleIndex = 0;
    private int femaleIndex = 0;

    public void clearMales(){
        this.males.clear();
    }

    public void clearFemales(){
        this.females.clear();
    }

    public boolean isStartMale(){
        return maleIndex == 0;
    }

    public void setMales(List<User> males) {
        this.males = males;
    }

    public void setFemales(List<User> females) {
        this.females = females;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public void setPairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public boolean isEndMale(){
        return maleIndex == (males.size() - 1);
    }

    public boolean isStarFemale(){
        return femaleIndex == 0;
    }

    public boolean isEndFemale(){
        return femaleIndex == (females.size() - 1);
    }

    public void incrementMaleIndex(){
        if (maleIndex < males.size() - 1){
            maleIndex++;
        }
    }

    public void decrementMaleIndex(){
        if (maleIndex > 0){
            maleIndex--;
        }
    }

    public void incrementFemaleIndex(){
        if (femaleIndex < females.size() - 1){
            femaleIndex++;
        }
    }

    public void decrementFemaleIndex(){
        if (femaleIndex > 0){
            femaleIndex--;
        }
    }

    public User getMale(){
        return males.get(maleIndex);
    }

    public User getFemale(){
        return females.get(femaleIndex);
    }

    public List<User> getMales() {
        return males;
    }

    public List<User> getFemales() {
        return females;
    }

    public void addMale(User male){
        males.add(male);
    }

    public void addFemale(User female){
        females.add(female);
    }

    public DefaultListModel<String> createListModel(){
        DefaultListModel<String> result = new DefaultListModel<>();

        for (var pair : pairs){
            StringBuilder builder = new StringBuilder();
            builder.append(pair.getMale().getName()).append(" ");
            builder.append(pair.getMale().getSurname()).append(" + ");
            builder.append(pair.getFemale().getName()).append(" ");
            builder.append(pair.getFemale().getSurname()).append(" = ");
            builder.append(pair.getCompatibility()).append("%");
            result.addElement(builder.toString());
        }
        return result;
    }
}
