package edu.bsu.ds_01.controller.main;

import edu.bsu.ds_01.controller.MainController;
import edu.bsu.ds_01.model.TextModel;
import edu.bsu.ds_01.reader.Reader;
import edu.bsu.ds_01.reader.impl.TextFileReader;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class OpenFileController extends MainController implements ActionListener{

    public OpenFileController(TextModel model) {
        super(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt", "docx");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("./resources/"));
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            File targetFile = chooser.getSelectedFile();
            if (!targetFile.exists()){
                JOptionPane.showMessageDialog(null, "File doesn't exists");
            }else{
                Reader reader = new TextFileReader();
                try {
                    String path = targetFile.getPath();
                    this.model.insertText(reader.readFile(path));
                    this.model.setCurrentFileName(path);
                } catch (FileNotFoundException exception) {
                    JOptionPane.showMessageDialog(null, "File not found");
                }
            }
        }
    }
}
