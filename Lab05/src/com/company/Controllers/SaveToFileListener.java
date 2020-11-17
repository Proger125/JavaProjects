package com.company.Controllers;

import com.company.Series.Series;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFileListener implements KeyListener {
    JFileChooser chooser;
    Series series;
    public SaveToFileListener(Series series){
        this.series = series;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){
            chooser = new JFileChooser();
            int result = chooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File targetFile = chooser.getSelectedFile();
                try{
                    if (!targetFile.exists()){
                        targetFile.createNewFile();
                    }
                    FileWriter writer = new FileWriter(targetFile);
                    writer.write(series.toString());
                    writer.close();
                }catch (IOException exception){
                    exception.printStackTrace();
                }
            }
        }
    }
}
