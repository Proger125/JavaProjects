package edu.bsu.ds_02.controller.main.saveImpl;

import edu.bsu.ds_02.controller.MainController;
import edu.bsu.ds_02.controller.main.SaveAsFile;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveAsFileController extends MainController implements ActionListener, SaveAsFile {
    public SaveAsFileController(Users users, UtilModel utilModel) {
        super(users, utilModel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean result = saveAsFile(users);
        if (result){
            JOptionPane.showMessageDialog(null, "File was saved");
        }else{
            JOptionPane.showMessageDialog(null, "File wasn't saved");
        }
    }
}
