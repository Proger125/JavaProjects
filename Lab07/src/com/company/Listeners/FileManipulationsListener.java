package com.company.Listeners;

import com.company.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class FileManipulationsListener implements KeyListener {
    private final View view;
    public FileManipulationsListener(View view){
        this.view = view;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_V){
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File targetFile = chooser.getSelectedFile();
                try{
                    Image image = ImageIO.read(targetFile);
                    view.getDrawPanel().insertImage(image);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File targetFile = chooser.getSelectedFile();
                try{
                    if (!targetFile.exists()){
                        targetFile.createNewFile();
                    }
                    ImageIO.write(view.getDrawPanel().getBufferedImage(), "PNG", targetFile);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
