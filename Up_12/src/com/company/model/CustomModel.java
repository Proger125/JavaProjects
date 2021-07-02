package com.company.model;

import java.util.ArrayList;
import java.util.List;

import com.company.entity.Gem;
import com.company.view.View;


public class CustomModel {
    private List<Gem> elements;
    private View view;
    private CustomTableModel model;
    public CustomModel(View view){
        this.view = view;
        elements = new ArrayList<>();
        model = new CustomTableModel(elements);
    }

    public List<Gem> getElements() {
        return new ArrayList<>(elements);
    }

    public void setElements(List<Gem> elements) {
        this.elements.clear();
        this.elements.addAll(elements);
        update();
    }

    public void addElement(Gem gem){
        this.elements.add(gem);
        update();
    }

    public void removeSelectedElement(){
        int index = view.getPanel().getTable().getSelectedRow();
        if (index != -1){
            this.elements.remove(index);
            update();
        }
    }
    public CustomTableModel getModel() {
        return model;
    }


    private void update(){
        model.fireTableDataChanged();
    }
}
