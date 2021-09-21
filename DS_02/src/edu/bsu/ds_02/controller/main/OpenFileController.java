package edu.bsu.ds_02.controller.main;

import com.google.gson.Gson;
import edu.bsu.ds_02.controller.util.DistributionController;
import edu.bsu.ds_02.controller.MainController;
import edu.bsu.ds_02.model.User;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;
import edu.bsu.ds_02.view.main.CustomFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class OpenFileController extends MainController implements ActionListener {
    private final CustomFrame frame;

    public OpenFileController(Users users, UtilModel utilModel, CustomFrame frame) {
        super(users, utilModel);
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON", "json");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("./resources/"));
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            File targetFile = chooser.getSelectedFile();
            if (!targetFile.exists()){
                JOptionPane.showMessageDialog(null, "File doesn't exists");
            }else{
                try{
                    utilModel.setCurrentFileName(targetFile.getPath());

                    Gson gson = new Gson();
                    User[] users =  gson.fromJson(new FileReader(targetFile), User[].class);

                    DistributionController distributionController = new DistributionController(this.users, this.utilModel);
                    distributionController.distributeUsers(users);
                    distributionController.setCurrentUsers(frame);
                } catch (FileNotFoundException exception) {
                    JOptionPane.showMessageDialog(null, "File doesn't exists");
                }

            }
        }
    }
}
