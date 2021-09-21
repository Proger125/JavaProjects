package edu.bsu.ds_02.controller.main;

import edu.bsu.ds_02.model.Users;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public interface SaveAsFile extends SaveFile{
    default boolean saveAsFile(Users users){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON", "json");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("./resources/"));
        int result = chooser.showOpenDialog(null);
        boolean flag = false;
        if (result == JFileChooser.APPROVE_OPTION){
            File targetFile = chooser.getSelectedFile();
            if (!targetFile.exists()){
                targetFile = new File(targetFile.getPath());
                boolean res = saveFile(users, targetFile.getPath());
                if (res){
                    flag =  true;
                }
            }
        }
        return flag;
    }
}
