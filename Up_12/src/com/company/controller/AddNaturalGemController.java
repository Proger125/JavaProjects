package com.company.controller;

import com.company.entity.NaturalGem;
import com.company.model.CustomModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddNaturalGemController extends MouseAdapter {
    private CustomModel model;
    public AddNaturalGemController(CustomModel model){
        this.model = model;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        model.addElement(new NaturalGem());
    }
}
