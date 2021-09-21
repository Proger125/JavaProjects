package edu.bsu.ds_02.controller.option;

import edu.bsu.ds_02.controller.MainController;
import edu.bsu.ds_02.controller.util.DistributionController;
import edu.bsu.ds_02.model.User;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;
import edu.bsu.ds_02.view.main.CustomFrame;
import edu.bsu.ds_02.view.option.AddUserFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AddUserController extends MainController implements ActionListener {

    private final AddUserFrame frame;
    private final CustomFrame customFrame;

    public AddUserController(Users users, UtilModel utilModel, AddUserFrame frame, CustomFrame customFrame) {
        super(users, utilModel);
        this.frame = frame;
        this.customFrame = customFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        User user = new User();

        String name = frame.getNameField().getText();
        if (name.isBlank()){
            JOptionPane.showMessageDialog(null, "Name field is empty");
            return;
        }

        String surname = frame.getSurnameField().getText();
        if (surname.isBlank()){
            JOptionPane.showMessageDialog(null, "Surname field is empty");
            return;
        }

        int age;
        try{
            age = Integer.parseInt(frame.getAgeField().getText());
        }catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Incorrect data in age field");
            return;
        }

        int height;
        try{
            height = Integer.parseInt(frame.getHeightField().getText());
        }catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Incorrect data in height field");
            return;
        }

        int weight;
        try{
            weight = Integer.parseInt(frame.getWeightField().getText());
        }catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Incorrect data in weight field");
            return;
        }

        User.Gender gender;
        if (frame.getMaleRadioButton().isSelected()){
            gender = User.Gender.MALE;
        } else if (frame.getFemaleRadioButton().isSelected()){
            gender = User.Gender.FEMALE;
        }else{
            JOptionPane.showMessageDialog(null, "Gender wasn't selected");
            return;
        }

        User.Appearance.HairColor hairColor;
        if (frame.getBlondHairRadioButton().isSelected()){
            hairColor = User.Appearance.HairColor.BLOND;
        } else if (frame.getBrownHairRadioButton().isSelected()){
            hairColor = User.Appearance.HairColor.BROWN;
        } else if (frame.getRedHairRadioButton().isSelected()){
            hairColor = User.Appearance.HairColor.RED;
        } else if (frame.getDarkHairRadioButton().isSelected()){
            hairColor = User.Appearance.HairColor.DARK;
        } else if (frame.getGrayHairRadioButton().isSelected()){
            hairColor = User.Appearance.HairColor.GRAY;
        } else{
            JOptionPane.showMessageDialog(null, "Hair color wasn't selected");
            return;
        }

        User.Appearance.EyeColor eyeColor;
        if (frame.getBlueEyeRadioButton().isSelected()){
            eyeColor = User.Appearance.EyeColor.BLUE;
        } else if (frame.getBrownEyeRadioButton().isSelected()){
            eyeColor = User.Appearance.EyeColor.BROWN;
        } else if (frame.getGreenEyeRadioButton().isSelected()){
            eyeColor = User.Appearance.EyeColor.GREEN;
        } else if (frame.getGrayEyeRadioButton().isSelected()){
            eyeColor = User.Appearance.EyeColor.GRAY;
        } else {
            JOptionPane.showMessageDialog(null, "Eye color wasn't selected");
            return;
        }
        int income;
        try{
            income = Integer.parseInt(frame.getIncomeField().getText());
        } catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Incorrect data in income field");
            return;
        }

        User.FinanceInfo.Accommodation accommodation;
        if (frame.getFlatRadioButton().isSelected()){
            accommodation = User.FinanceInfo.Accommodation.FLAT;
        } else if (frame.getHouseRadioButton().isSelected()){
            accommodation = User.FinanceInfo.Accommodation.HOUSE;
        } else if (frame.getNoneRadioButton().isSelected()){
            accommodation = User.FinanceInfo.Accommodation.NONE;
        } else {
            JOptionPane.showMessageDialog(null, "Accommodation wasn't selected");
            return;
        }

        boolean isDivorced;
        if (frame.getYesRadioButton().isSelected()){
            isDivorced = true;
        } else if (frame.getNoRadioButton().isSelected()){
            isDivorced = false;
        } else {
            JOptionPane.showMessageDialog(null, "IsDivorced wasn't selected");
            return;
        }

        int children;
        try{
            children = Integer.parseInt(frame.getChildrenField().getText());
        } catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Incorrect data in children field");
            return;
        }

        String requirements = frame.getRequirementsArea().getText();
        String[] lines = requirements.split("\n");

        Map<String, String> requirementsMap = new HashMap<>();
        for (var line : lines){
            int indexOfColon = line.indexOf(':');
            String property = line.substring(0, indexOfColon);
            property = property.trim().toLowerCase();

            String value = line.substring(indexOfColon + 1, line.length() - 1);
            value = value.trim().toUpperCase();

            requirementsMap.put(property, value);
        }

        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        user.setGender(gender);

        User.Appearance appearance = new User.Appearance();
        appearance.setHeight(height);
        appearance.setWeight(weight);
        appearance.setHairColor(hairColor);
        appearance.setEyeColor(eyeColor);

        user.setAppearance(appearance);

        User.FinanceInfo financeInfo = new User.FinanceInfo();
        financeInfo.setIncome(income);
        financeInfo.setAccommodation(accommodation);

        user.setFinanceInfo(financeInfo);

        User.OtherInfo otherInfo = new User.OtherInfo();
        otherInfo.setDivorced(isDivorced);
        otherInfo.setChildrenAmount(children);

        user.setOtherInfo(otherInfo);
        user.setRequirements(requirementsMap);

        DistributionController controller = new DistributionController(users, utilModel);
        if (gender == User.Gender.MALE){
            users.addMale(user);
            controller.setCurrentUser(customFrame.getMalePanel().getInfoPanel().getInfoPanel(), user);
        }else{
            users.addFemale(user);
            controller.setCurrentUser(customFrame.getFemalePanel().getInfoPanel().getInfoPanel(), user);
        }

        frame.setVisible(false);
    }
}
