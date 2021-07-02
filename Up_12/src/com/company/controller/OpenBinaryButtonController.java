package com.company.controller;

import com.company.entity.Gem;
import com.company.model.CustomModel;
import com.company.parser.DOMParser;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

public class OpenBinaryButtonController extends MouseAdapter {
    private CustomModel model;
    public OpenBinaryButtonController(CustomModel model){
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

            try {
                FileInputStream stream = new FileInputStream(targetFile);
                ObjectInputStream inputStream = new ObjectInputStream(stream);
                model.setElements((ArrayList<Gem>)inputStream.readObject());
            } catch (IOException | ClassNotFoundException exception) {
                JOptionPane.showMessageDialog(null, "File not found");
            }
        }
    }
}
