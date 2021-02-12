package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dialog extends JFrame {
    private final JTextField bookNumberInput = new JTextField();
    private final JTextField surnameInput = new JTextField();
    private final JTextField courseInput = new JTextField();
    private final JTextField groupInput = new JTextField();
    private final Model model;
    public Dialog(String title, Model model){
        super(title);
        this.model = model;
        this.setSize(400, 400);
        JPanel mainPanel = new JPanel(new GridLayout(9, 1));
        addComponents(mainPanel);
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }
    private void addComponents(JPanel panel){
        JLabel bookLabel = new JLabel("Record book number:");
        panel.add(bookLabel);
        panel.add(bookNumberInput);
        JLabel surnameLabel = new JLabel("Surname:");
        panel.add(surnameLabel);
        panel.add(surnameInput);
        JLabel courseLabel = new JLabel("Course:");
        panel.add(courseLabel);
        panel.add(courseInput);
        JLabel groupLabel = new JLabel("Group:");
        panel.add(groupLabel);
        panel.add(groupInput);
        JButton submitButton = new JButton("Submit");
        submitButton.addMouseListener(new SubmitButtonListener(this));
        panel.add(submitButton);
    }
    private class SubmitButtonListener extends MouseAdapter{
        private final JFrame frame;
        SubmitButtonListener(JFrame frame){
            this.frame = frame;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                int bookNumber = Integer.parseInt(bookNumberInput.getText());
                String surname = surnameInput.getText();
                int course = Integer.parseInt(courseInput.getText());
                int group = Integer.parseInt(groupInput.getText());
                Student student = new Student(bookNumber, surname, course, group);
                model.getModel().addElement(student);
                frame.setVisible(false);
            }
            catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "Some fields are incorrect");
            }
        }
    }
}
