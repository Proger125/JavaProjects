package edu.bsu.ds_02.controller.frame;

import edu.bsu.ds_02.controller.FrameController;
import edu.bsu.ds_02.controller.util.DistributionController;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.view.main.CustomFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaleButtonsController extends FrameController implements ActionListener {
    private DistributionController distributionController;

    public MaleButtonsController(Users users, CustomFrame frame) {
        super(users, frame);
        this.distributionController = new DistributionController(users, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == frame.getMalePanel().getInfoPanel().getNextButton()){
            users.incrementMaleIndex();
            button.setEnabled(!users.isEndMale());
            JButton prevButton = frame.getMalePanel().getInfoPanel().getPrevButton();
            prevButton.setEnabled(true);
        } else {
            users.decrementMaleIndex();
            button.setEnabled(!users.isStartMale());
            JButton nextButton = frame.getMalePanel().getInfoPanel().getNextButton();
            nextButton.setEnabled(true);
        }
        distributionController.setCurrentUser(frame.getMalePanel().getInfoPanel().getInfoPanel(), users.getMale());
    }
}
