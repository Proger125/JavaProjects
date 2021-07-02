package com.company.controller;

import com.company.entity.Gem;
import com.company.entity.NaturalGem;
import com.company.model.CustomModel;
import com.company.model.CustomTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteButtonController extends MouseAdapter {
    private CustomModel model;
    public DeleteButtonController(CustomModel model){
        this.model = model;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        model.removeSelectedElement();
    }
}
