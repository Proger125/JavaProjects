package edu.bsu.ds_01.controller.main;

import edu.bsu.ds_01.controller.MainController;
import edu.bsu.ds_01.model.TextModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFileController extends MainController implements ActionListener {
    public SaveFileController(TextModel model) {
        super(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(model.getCurrentFileName()))) {
            writer.write(model.getText());
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, "Current file doesn't exist");
        }
    }
}
