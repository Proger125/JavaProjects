package com.company.controller;

import com.company.model.CustomModel;
import com.company.model.CustomTableModel;
import com.company.writer.DOMWriter;

import javax.swing.*;
import javax.xml.transform.TransformerException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class SaveButtonController extends MouseAdapter {
    private static final String DEFAULT_FILE_NAME = "new_gems.xml";
    private CustomModel model;
    public SaveButtonController(CustomModel model){
        this.model = model;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("./resources/"));
        int result = chooser.showSaveDialog(null);
        File targetFile;
        if (result == JFileChooser.APPROVE_OPTION){
            targetFile = chooser.getSelectedFile();
            if (!targetFile.exists()){
                targetFile = new File(targetFile.getPath());
            }
            DOMWriter writer = new DOMWriter();
            try {
                writer.write(model.getElements(), targetFile.getPath());
            } catch (TransformerException transformerException) {
                transformerException.printStackTrace();
            }
        }
    }
}
