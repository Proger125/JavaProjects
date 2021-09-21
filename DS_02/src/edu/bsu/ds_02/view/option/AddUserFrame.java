package edu.bsu.ds_02.view.option;

import edu.bsu.ds_02.controller.option.AddUserController;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;
import edu.bsu.ds_02.view.main.CustomFrame;

import javax.swing.*;

public class AddUserFrame extends JFrame {

    private final Users users;
    private final UtilModel utilModel;
    private final CustomFrame customFrame;
    private final Fields fields = new Fields();

    public AddUserFrame(String title, Users users, UtilModel utilModel, CustomFrame customFrame){
        super(title);

        this.users = users;
        this.utilModel = utilModel;
        this.customFrame = customFrame;

        this.setContentPane(createMainPanel());
        this.setSize(900, 500);
        this.setVisible(true);
    }



    private JPanel createMainPanel(){
        JPanel mainPanel = new JPanel(null);

        JLabel nameLabel = new JLabel("Имя: ");
        nameLabel.setSize(100, 20);
        nameLabel.setLocation(20, 20);
        mainPanel.add(nameLabel);

        fields.nameField.setSize(100, 20);
        fields.nameField.setLocation(130, 20);
        mainPanel.add(fields.nameField);

        JLabel surnameLabel = new JLabel("Фамилия: ");
        surnameLabel.setSize(100, 20);
        surnameLabel.setLocation(20, 70);
        mainPanel.add(surnameLabel);

        fields.surnameField.setSize(100, 20);
        fields.surnameField.setLocation(130, 70);
        mainPanel.add(fields.surnameField);

        JLabel ageLabel = new JLabel("Возраст: ");
        ageLabel.setSize(100, 20);
        ageLabel.setLocation(20, 120);
        mainPanel.add(ageLabel);

        fields.ageField.setSize(100, 20);
        fields.ageField.setLocation(130, 120);
        mainPanel.add(fields.ageField);

        JLabel genderLabel = new JLabel("Пол: ");
        genderLabel.setSize(100, 20);
        genderLabel.setLocation(20, 170);
        mainPanel.add(genderLabel);

        fields.maleRadioButton.setSize(100, 20);
        fields.maleRadioButton.setLocation(130, 170);
        mainPanel.add(fields.maleRadioButton);

        fields.femaleRadioButton.setSize(100, 20);
        fields.femaleRadioButton.setLocation(240, 170);
        mainPanel.add(fields.femaleRadioButton);

        JLabel heightLabel = new JLabel("Рост: ");
        heightLabel.setSize(100, 20);
        heightLabel.setLocation(20, 220);
        mainPanel.add(heightLabel);

        fields.heightField.setSize(100, 20);
        fields.heightField.setLocation(130, 220);
        mainPanel.add(fields.heightField);

        JLabel weightLabel = new JLabel("Вес: ");
        weightLabel.setSize(100, 20);
        weightLabel.setLocation(20, 270);
        mainPanel.add(weightLabel);

        fields.weightField.setSize(100, 20);
        fields.weightField.setLocation(130, 270);
        mainPanel.add(fields.weightField);

        JLabel hairLabel = new JLabel("Цвет волос: ");
        hairLabel.setSize(100, 20);
        hairLabel.setLocation(400, 20);
        mainPanel.add(hairLabel);

        fields.blondHairRadioButton.setSize(80, 20);
        fields.blondHairRadioButton.setLocation(400, 50);
        mainPanel.add(fields.blondHairRadioButton);

        fields.brownHairRadioButton.setSize(80, 20);
        fields.brownHairRadioButton.setLocation(490, 50);
        mainPanel.add(fields.brownHairRadioButton);

        fields.redHairRadioButton.setSize(80, 20);
        fields.redHairRadioButton.setLocation(580, 50);
        mainPanel.add(fields.redHairRadioButton);

        fields.darkHairRadioButton.setSize(80, 20);
        fields.darkHairRadioButton.setLocation(670, 50);
        mainPanel.add(fields.darkHairRadioButton);

        fields.grayHairRadioButton.setSize(80, 20);
        fields.grayHairRadioButton.setLocation(760, 50);
        mainPanel.add(fields.grayHairRadioButton);

        JLabel eyeLabel = new JLabel("Цвет глаз: ");
        eyeLabel.setSize(100, 20);
        eyeLabel.setLocation(400, 80);
        mainPanel.add(eyeLabel);

        fields.blueEyeRadioButton.setSize(80, 20);
        fields.blueEyeRadioButton.setLocation(400, 110);
        mainPanel.add(fields.blueEyeRadioButton);

        fields.brownEyeRadioButton.setSize(80, 20);
        fields.brownEyeRadioButton.setLocation(490, 110);
        mainPanel.add(fields.brownEyeRadioButton);

        fields.greenEyeRadioButton.setSize(80, 20);
        fields.greenEyeRadioButton.setLocation(580, 110);
        mainPanel.add(fields.greenEyeRadioButton);

        fields.grayEyeRadioButton.setSize(80, 20);
        fields.grayEyeRadioButton.setLocation(670, 110);
        mainPanel.add(fields.grayEyeRadioButton);

        JLabel incomeLabel = new JLabel("Доход: ");
        incomeLabel.setSize(100, 20);
        incomeLabel.setLocation(400, 140);
        mainPanel.add(incomeLabel);

        fields.incomeField.setSize(100, 20);
        fields.incomeField.setLocation(510, 140);
        mainPanel.add(fields.incomeField);

        JLabel accommodationLabel = new JLabel("Жильё: ");
        accommodationLabel.setSize(100, 20);
        accommodationLabel.setLocation(400, 170);
        mainPanel.add(accommodationLabel);

        fields.flatRadioButton.setSize(80, 20);
        fields.flatRadioButton.setLocation(400, 200);
        mainPanel.add(fields.flatRadioButton);

        fields.houseRadioButton.setSize(80, 20);
        fields.houseRadioButton.setLocation(490, 200);
        mainPanel.add(fields.houseRadioButton);

        fields.noneRadioButton.setSize(80, 20);
        fields.noneRadioButton.setLocation(580, 200);
        mainPanel.add(fields.noneRadioButton);

        JLabel isDivorcedLabel = new JLabel("Разведён: ");
        isDivorcedLabel.setSize(100, 20);
        isDivorcedLabel.setLocation(400, 230);
        mainPanel.add(isDivorcedLabel);

        fields.yesRadioButton.setSize(80, 20);
        fields.yesRadioButton.setLocation(400, 260);
        mainPanel.add(fields.yesRadioButton);

        fields.noRadioButton.setSize(80, 20);
        fields.noRadioButton.setLocation(490, 260);
        mainPanel.add(fields.noRadioButton);

        JLabel childrenLabel = new JLabel("Дети: ");
        childrenLabel.setSize(100, 20);
        childrenLabel.setLocation(400, 290);
        mainPanel.add(childrenLabel);

        fields.childrenField.setSize(100, 20);
        fields.childrenField.setLocation(510, 290);
        mainPanel.add(fields.childrenField);

        JLabel requirementsLabel = new JLabel("Требования(формат -> параметр: значение): ");
        requirementsLabel.setSize(300, 20);
        requirementsLabel.setLocation(20, 350);
        mainPanel.add(requirementsLabel);

        fields.requirementsArea.setSize(400, 180);
        fields.requirementsArea.setLocation(330, 320);
        mainPanel.add(fields.requirementsArea);

        fields.addUserButton.setSize(100, 50);
        fields.addUserButton.setLocation(750, 375);
        fields.addUserButton.addActionListener(new AddUserController(users, utilModel, this, customFrame));
        mainPanel.add(fields.addUserButton);

        return mainPanel;
    }
    public JTextField getNameField() {
        return fields.nameField;
    }

    public JTextField getSurnameField() {
        return fields.surnameField;
    }

    public JTextField getAgeField() {
        return fields.ageField;
    }

    public JTextField getHeightField() {
        return fields.heightField;
    }

    public JTextField getWeightField() {
        return fields.weightField;
    }

    public JRadioButton getMaleRadioButton() {
        return fields.maleRadioButton;
    }

    public JRadioButton getFemaleRadioButton() {
        return fields.femaleRadioButton;
    }

    public JRadioButton getBlondHairRadioButton() {
        return fields.blondHairRadioButton;
    }

    public JRadioButton getBrownHairRadioButton() {
        return fields.brownHairRadioButton;
    }

    public JRadioButton getRedHairRadioButton() {
        return fields.redHairRadioButton;
    }

    public JRadioButton getDarkHairRadioButton() {
        return fields.darkHairRadioButton;
    }

    public JRadioButton getGrayHairRadioButton() {
        return fields.grayHairRadioButton;
    }

    public JRadioButton getBlueEyeRadioButton() {
        return fields.blueEyeRadioButton;
    }

    public JRadioButton getBrownEyeRadioButton() {
        return fields.brownEyeRadioButton;
    }

    public JRadioButton getGreenEyeRadioButton() {
        return fields.greenEyeRadioButton;
    }

    public JRadioButton getGrayEyeRadioButton() {
        return fields.grayEyeRadioButton;
    }

    public JTextField getIncomeField() {
        return fields.incomeField;
    }

    public JRadioButton getFlatRadioButton() {
        return fields.flatRadioButton;
    }

    public JRadioButton getHouseRadioButton() {
        return fields.houseRadioButton;
    }

    public JRadioButton getNoneRadioButton() {
        return fields.noneRadioButton;
    }

    public JRadioButton getYesRadioButton() {
        return fields.yesRadioButton;
    }

    public JRadioButton getNoRadioButton() {
        return fields.noRadioButton;
    }

    public JTextField getChildrenField() {
        return fields.childrenField;
    }

    public JTextArea getRequirementsArea() {
        return fields.requirementsArea;
    }

    public JButton getAddUserButton() {
        return fields.addUserButton;
    }
    private static class Fields{
        JTextField nameField = new JTextField();
        JTextField surnameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField heightField = new JTextField();
        JTextField weightField = new JTextField();

        JRadioButton maleRadioButton = new JRadioButton("Мужчина");
        JRadioButton femaleRadioButton = new JRadioButton("Женщина");

        JRadioButton blondHairRadioButton = new JRadioButton("Блонд");
        JRadioButton brownHairRadioButton = new JRadioButton("Шатен");
        JRadioButton redHairRadioButton = new JRadioButton("Рыжий");
        JRadioButton darkHairRadioButton = new JRadioButton("Тёмный");
        JRadioButton grayHairRadioButton = new JRadioButton("Седой");

        JRadioButton blueEyeRadioButton = new JRadioButton("Голубой");
        JRadioButton brownEyeRadioButton = new JRadioButton("Карий");
        JRadioButton greenEyeRadioButton = new JRadioButton("Зелёный");
        JRadioButton grayEyeRadioButton = new JRadioButton("Серый");

        JTextField incomeField = new JTextField();

        JRadioButton flatRadioButton = new JRadioButton("Квартира");
        JRadioButton houseRadioButton = new JRadioButton("Дом");
        JRadioButton noneRadioButton = new JRadioButton("Нет");

        JRadioButton yesRadioButton = new JRadioButton("Да");
        JRadioButton noRadioButton = new JRadioButton("Нет");

        JTextField childrenField = new JTextField();

        JTextArea requirementsArea = new JTextArea();

        JButton addUserButton = new JButton("Добавить");

        Fields(){
            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(maleRadioButton);
            genderGroup.add(femaleRadioButton);

            ButtonGroup hairGroup = new ButtonGroup();
            hairGroup.add(blondHairRadioButton);
            hairGroup.add(brownHairRadioButton);
            hairGroup.add(redHairRadioButton);
            hairGroup.add(darkHairRadioButton);
            hairGroup.add(grayHairRadioButton);

            ButtonGroup eyeGroup = new ButtonGroup();
            eyeGroup.add(blueEyeRadioButton);
            eyeGroup.add(brownEyeRadioButton);
            eyeGroup.add(greenEyeRadioButton);
            eyeGroup.add(grayEyeRadioButton);

            ButtonGroup accommodationGroup = new ButtonGroup();
            accommodationGroup.add(flatRadioButton);
            accommodationGroup.add(houseRadioButton);
            accommodationGroup.add(noneRadioButton);

            ButtonGroup isDivorcedGroup = new ButtonGroup();
            isDivorcedGroup.add(yesRadioButton);
            isDivorcedGroup.add(noRadioButton);
        }

    }
}
