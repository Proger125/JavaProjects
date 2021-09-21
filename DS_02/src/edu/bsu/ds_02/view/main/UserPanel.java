package edu.bsu.ds_02.view.main;

import edu.bsu.ds_02.controller.frame.FemaleButtonsController;
import edu.bsu.ds_02.controller.frame.MaleButtonsController;
import edu.bsu.ds_02.model.Users;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {
    private final String gender;
    private final Users users;
    private final CustomFrame frame;
    private final InfoWrapperPanel infoPanel = new InfoWrapperPanel();

    public UserPanel(String gender, Users users, CustomFrame frame) {
        super(new BorderLayout());
        this.gender = gender;
        this.users = users;
        this.frame = frame;

        JLabel genderLabel = new JLabel(gender);
        this.add(genderLabel, BorderLayout.NORTH);

        if (gender.equals("Мужчины")){
            infoPanel.getNextButton().addActionListener(new MaleButtonsController(users, frame));
            infoPanel.getPrevButton().addActionListener(new MaleButtonsController(users, frame));
        }else{
            infoPanel.getNextButton().addActionListener(new FemaleButtonsController(users, frame));
            infoPanel.getPrevButton().addActionListener(new FemaleButtonsController(users, frame));
        }

        this.add(infoPanel, BorderLayout.CENTER);
    }

    public InfoWrapperPanel getInfoPanel() {
        return infoPanel;
    }

    public static class InfoWrapperPanel extends JPanel{
        private final JButton nextButton = new JButton("Следующий");
        private final JButton prevButton = new JButton("Предыдущий");
        private final InfoPanel infoPanel = new InfoPanel();
        public InfoWrapperPanel(){
            super(new BorderLayout());

            nextButton.setEnabled(false);
            prevButton.setEnabled(false);

            this.add(prevButton, BorderLayout.NORTH);
            this.add(nextButton, BorderLayout.SOUTH);

            this.add(infoPanel, BorderLayout.CENTER);
        }

        public JButton getNextButton() {
            return nextButton;
        }

        public JButton getPrevButton() {
            return prevButton;
        }

        public InfoPanel getInfoPanel() {
            return infoPanel;
        }

        public void setNextButtonEnabled(boolean value){
            nextButton.setEnabled(value);
        }

        public void setPrevButtonEnabled(boolean value){
            prevButton.setEnabled(value);
        }

        public static class InfoPanel extends JPanel{
            private final JLabel nameLabel = new JLabel();
            private final JLabel ageLabel = new JLabel();
            private final JLabel heightLabel = new JLabel();
            private final JLabel weightLabel = new JLabel();
            private final JLabel hairLabel = new JLabel();
            private final JLabel eyeLabel = new JLabel();

            private final JLabel incomeLabel = new JLabel();
            private final JLabel accommodationLabel = new JLabel();

            private final JLabel isDivorcedLabel = new JLabel();
            private final JLabel childrenLabel = new JLabel();


            public InfoPanel(){
                super(new GridLayout(10, 2));

                this.add(new JLabel("Имя:"));
                this.add(nameLabel);

                this.add(new JLabel("Возраст:"));
                this.add(ageLabel);

                this.add(new JLabel("Рост:"));
                this.add(heightLabel);

                this.add(new JLabel("Вес:"));
                this.add(weightLabel);

                this.add(new JLabel("Цвет волос: "));
                this.add(hairLabel);

                this.add(new JLabel("Цвет глаз: "));
                this.add(eyeLabel);

                this.add(new JLabel("Доход: "));
                this.add(incomeLabel);

                this.add(new JLabel("Жильё: "));
                this.add(accommodationLabel);

                this.add(new JLabel("Разведён ли: "));
                this.add(isDivorcedLabel);

                this.add(new JLabel("Дети: "));
                this.add(childrenLabel);
            }

            public void setName(String name){
                this.nameLabel.setText(name);
            }

            public void setAge(String age){
                this.ageLabel.setText(age);
            }

            public void setHeight(String height) {this.heightLabel.setText(height);}

            public void setWeight(String weight) {this.weightLabel.setText(weight);}

            public void setHairColor(String hairColor) {this.hairLabel.setText(hairColor);}

            public void setEyeColor(String eyeColor) {this.eyeLabel.setText(eyeColor);}

            public void setIncome(String income) {this.incomeLabel.setText(income);}

            public void setAccommodation(String accommodation) {this.accommodationLabel.setText(accommodation);}

            public void setIsDivorced(String isDivorced) {this.isDivorcedLabel.setText(isDivorced);}

            public void setChildrenLabel(String children) {this.childrenLabel.setText(children);}
        }
    }
}
