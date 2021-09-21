package edu.bsu.ds_02.controller.main;

import edu.bsu.ds_02.model.Users;

import javax.swing.*;
import java.io.*;

public interface SaveAsObject {
    default boolean saveAsObject(Users users){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("./resources/"));
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            File targetFile = chooser.getSelectedFile();
            if (!targetFile.exists()){
                targetFile = new File(targetFile.getPath());
            }
            try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(targetFile))){
                stream.writeObject(users.getMales());
                stream.writeObject(users.getFemales());
                return true;
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "File not found");
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(null, "Something went wrong");
            }
        }
        return false;
    }
}
