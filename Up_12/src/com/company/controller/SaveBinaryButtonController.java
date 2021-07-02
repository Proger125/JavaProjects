package com.company.controller;

import com.company.model.CustomModel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class SaveBinaryButtonController extends MouseAdapter {
    private CustomModel model;
    public SaveBinaryButtonController(CustomModel model){
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
            try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(targetFile))){
                stream.writeObject(model.getElements());
            } catch (FileNotFoundException exception) {
                JOptionPane.showMessageDialog(null, "File not found");
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(null, "Something wrong");
            }
        }
    }
}
