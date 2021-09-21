package edu.bsu.ds_01.controller;


import edu.bsu.ds_01.model.TextModel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface SaveAsController {
    default boolean saveAs(TextModel model){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt", "docx");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("./resources/"));
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            File targetFile = chooser.getSelectedFile();
            if (!targetFile.exists()){
                targetFile = new File(targetFile.getPath());
                try(BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile.getPath()))){
                    writer.write(model.getText());
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, "Problems with file...");
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
