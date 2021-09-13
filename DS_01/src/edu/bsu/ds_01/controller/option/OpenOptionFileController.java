package edu.bsu.ds_01.controller.option;

import com.google.gson.Gson;
import edu.bsu.ds_01.controller.OptionController;
import edu.bsu.ds_01.model.OptionFileModel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class OpenOptionFileController extends OptionController implements ActionListener {
    public OpenOptionFileController(OptionFileModel model) {
        super(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON files", "json");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("./resources/"));
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            File targetFile = chooser.getSelectedFile();
            if (!targetFile.exists()){
                JOptionPane.showMessageDialog(null, "File doesn't exists");
            }else{
                model.setFileName(targetFile.getPath());
                Gson gson = new Gson();
                try {
                    Map<String, String> map = new HashMap<>();
                    map = gson.fromJson(new FileReader(targetFile),map.getClass());
                    model.setRules(map);
                    JOptionPane.showMessageDialog(null, "Файл провекри переносов изменён!");
                } catch (FileNotFoundException exception) {
                    JOptionPane.showMessageDialog(null, "File not found");
                }
            }
        }
    }
}
