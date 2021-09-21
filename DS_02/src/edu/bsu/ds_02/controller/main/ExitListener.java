package edu.bsu.ds_02.controller.main;

import edu.bsu.ds_02.controller.MainController;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ExitListener extends MainController implements WindowListener, SaveAsFile {
    public ExitListener(Users users, UtilModel utilModel) {
        super(users, utilModel);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "Вы хотите сохранить текущий файл?", "Выход", JOptionPane.YES_NO_OPTION);
        boolean flag = true;
        if (result == JOptionPane.YES_OPTION){
            if (utilModel.getCurrentFileName() != null){
                flag = saveFile(users, utilModel.getCurrentFileName());
            }else{
                flag = saveAsFile(users);
            }
            if (flag){
                JOptionPane.showMessageDialog(null, "File was saved");
            }else{
                JOptionPane.showMessageDialog(null, "File wasn't saved");
            }
        }
        if (flag){
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
