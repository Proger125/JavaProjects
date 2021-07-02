package com.company.controller;

import com.company.model.CustomModel;
import com.company.parser.DOMParser;
import com.company.validator.XMLValidator;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class OpenButtonController extends MouseAdapter {
    private final CustomModel model;
    public OpenButtonController(CustomModel model){
        this.model = model;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("./resources/"));
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            File targetFile = chooser.getSelectedFile();
            if (!targetFile.exists()){
                JOptionPane.showMessageDialog(null, "File doesn't exists");
            }
            if (XMLValidator.validateXML(targetFile.getPath())){
                JOptionPane.showMessageDialog(null, "File  matches XSD scheme");
                DOMParser parser = DOMParser.getInstance();
                parser.buildSetGems(targetFile.getPath());
                model.setElements(parser.getGems());
            }
        }
    }
}
