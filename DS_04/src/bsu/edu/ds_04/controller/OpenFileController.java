package bsu.edu.ds_04.controller;

import bsu.edu.ds_04.model.CustomModel;
import bsu.edu.ds_04.view.CustomView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.stream.Stream;

public record OpenFileController(CustomModel model,
                                 CustomView view) implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Java files", "java");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("./resources"));
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File targetFile = chooser.getSelectedFile();
            if (!targetFile.exists()) {
                JOptionPane.showMessageDialog(null, "File doesn't exists");
            } else {
                try (BufferedReader reader = new BufferedReader(new FileReader(targetFile))) {
                    Stream<String> stream = reader.lines();
                    StringBuilder builder = new StringBuilder();
                    stream.forEach(a -> builder.append(a).append("\n"));
                    model.setText(builder.toString());
                    view.setInitAreaText(builder.toString());
                } catch (FileNotFoundException fileNotFoundException) {
                    JOptionPane.showMessageDialog(null, "File not found");
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Something went wrong!");
                }
            }
        }
    }
}
