package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Model {
    private final DefaultListModel<Student> model;
    private DefaultListModel<Student> sortedModel;
    public DefaultListModel<Student> getModel() {
        return model;
    }

    public void setModel(DefaultListModel<Student> model) {
        while(this.model.size() != 0){
            this.model.removeElementAt(0);
        }
        for (int i = 0; i < model.size(); i++){
            this.model.addElement(model.get(i));
        }
    }

    public DefaultListModel<Student> getSortedModel() {
        return sortedModel;
    }
    public ArrayList<Student> getArrayListModel(){
        findUniqueSurnames();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0; i < model.size(); i++){
            list.add(model.get(i));
        }
        return list;
    }
    public void findUniqueSurnames(){
        for (int i = 0; i < model.size(); i++){
            model.get(i).setUnique(true);
        }
        for (int i = 0; i < model.size() - 1; i++){
            for (int j = i + 1; j < model.size(); j++){
                if (model.get(i).getSurname().equals(model.get(j).getSurname())){
                    model.get(i).setUnique(false);
                    model.get(j).setUnique(false);
                }
            }
        }
    }
    public void setSortedModel(DefaultListModel<Student> sortedModel) {
        while(this.sortedModel.size() != 0){
            this.sortedModel.removeElementAt(0);
        }
        for (int i = 0; i < sortedModel.size(); i++){
            this.sortedModel.addElement(sortedModel.get(i));
        }
    }

    public Model(){
        this.model = new DefaultListModel<>();
        this.sortedModel = new DefaultListModel<>();
    }
}
