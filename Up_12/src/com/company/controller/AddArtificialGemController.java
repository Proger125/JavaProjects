package com.company.controller;

import com.company.entity.ArtificialGem;
import com.company.entity.NaturalGem;
import com.company.model.CustomModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddArtificialGemController extends MouseAdapter {
    private CustomModel model;
    public AddArtificialGemController(CustomModel model){
        this.model = model;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        model.addElement(new ArtificialGem());
    }
}
