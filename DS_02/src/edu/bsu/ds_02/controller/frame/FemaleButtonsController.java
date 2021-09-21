package edu.bsu.ds_02.controller.frame;

import edu.bsu.ds_02.controller.FrameController;
import edu.bsu.ds_02.controller.util.DistributionController;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.view.main.CustomFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FemaleButtonsController extends FrameController implements ActionListener {

    private DistributionController distributionController;

    public FemaleButtonsController(Users users, CustomFrame frame) {
        super(users, frame);
        this.distributionController = new DistributionController(users, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == frame.getFemalePanel().getInfoPanel().getNextButton()){
            users.incrementFemaleIndex();
            button.setEnabled(!users.isEndFemale());
            JButton prevButton = frame.getFemalePanel().getInfoPanel().getPrevButton();
            prevButton.setEnabled(true);
        }else{
            users.decrementFemaleIndex();
            button.setEnabled(!users.isStarFemale());
            JButton nextButton = frame.getFemalePanel().getInfoPanel().getNextButton();
            nextButton.setEnabled(true);
        }
        distributionController.setCurrentUser(frame.getFemalePanel().getInfoPanel().getInfoPanel(), users.getFemale());
    }
}
