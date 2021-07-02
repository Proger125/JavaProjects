package com.company.controller;

import com.company.parser.SAXParser;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class MaxTransparencyButtonController extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("./resources/"));
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            File targetFile = chooser.getSelectedFile();
            if (!targetFile.exists()){
                JOptionPane.showMessageDialog(null, "File doesn't exists");
                return;
            }
            SAXParser parser = SAXParser.getInstance();
            int answer = parser.calcMaxTransparency(targetFile.getPath());
            JOptionPane.showMessageDialog(null, "Максимальная прозрачность камня: " + answer);
        }
    }
}
