package edu.bsu.ds_02.controller.main.saveImpl;

import edu.bsu.ds_02.controller.MainController;
import edu.bsu.ds_02.controller.main.SaveAsObject;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveAsObjectController extends MainController implements ActionListener, SaveAsObject {
    public SaveAsObjectController(Users users, UtilModel utilModel) {
        super(users, utilModel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean result = saveAsObject(users);
        if (result){
            JOptionPane.showMessageDialog(null, "File was saved");
        }else{
            JOptionPane.showMessageDialog(null, "File wasn't saved");
        }
    }
}
