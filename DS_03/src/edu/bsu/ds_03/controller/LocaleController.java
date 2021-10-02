package edu.bsu.ds_03.controller;

import edu.bsu.ds_03.model.LocaleModel;
import edu.bsu.ds_03.view.CustomFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class LocaleController implements ActionListener {

    private final LocaleModel localeModel;
    private final CustomFrame customFrame;

    public LocaleController(LocaleModel localeModel, CustomFrame customFrame){
        this.localeModel = localeModel;
        this.customFrame = customFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButtonMenuItem item = (JRadioButtonMenuItem) e.getSource();
        if (item == customFrame.getFields().getEnglishButton()){
            localeModel.setLocale(new Locale("en"));
        } else {
            localeModel.setLocale(new Locale("ru"));
        }
    }
}
