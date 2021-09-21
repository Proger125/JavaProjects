package edu.bsu.ds_02.controller.main;

import edu.bsu.ds_02.controller.MainController;
import edu.bsu.ds_02.model.User;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

public class OpenFileObjectController extends MainController implements ActionListener {
    public OpenFileObjectController(Users users, UtilModel utilModel) {
        super(users, utilModel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("./resources/"));
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            File targetFile = chooser.getSelectedFile();
            if (!targetFile.exists()){
                JOptionPane.showMessageDialog(null, "File doesn't exist");
            }
            try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(targetFile))){
                users.setMales((List<User>) stream.readObject());
                users.setFemales((List<User>) stream.readObject());
            } catch (IOException | ClassNotFoundException exception) {
                JOptionPane.showMessageDialog(null, "Something went wrong");
            }
        }
    }
}
