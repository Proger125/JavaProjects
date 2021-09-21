package edu.bsu.ds_01.controller.main;

import edu.bsu.ds_01.controller.MainController;
import edu.bsu.ds_01.controller.SaveAsController;
import edu.bsu.ds_01.model.TextModel;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;

public class ExitListener extends MainController implements WindowListener, SaveAsController {
    public ExitListener(TextModel model) {
        super(model);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "Вы хотите сохранить текущий файл", "Выход", JOptionPane.YES_NO_OPTION);
        boolean flag = true;
        if (result == JOptionPane.YES_OPTION){
            if (model.getCurrentFileName() != null){
                try(FileWriter writer = new FileWriter(model.getCurrentFileName())){
                    writer.write(model.getText());
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, "Файл не найден");
                }
            }else{
                flag = saveAs(model);
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
