package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class CustomPanel extends JPanel {
    private final JFrame parentFrame;
    private final Model model;
    private static final int MARGIN = 100;
    private final Timer timer;
    public CustomPanel(JFrame frame, Model model){
        this.model = model;
        this.parentFrame = frame;
        this.setSize(new Dimension(500, 500));
        this.setLayout(new BorderLayout());
        this.addComponents();
        timer = new Timer(100, new TimerListener(model, this));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (model.getImageIcon() != null){
            int radius = Math.min(this.getWidth() / 2, this.getHeight() / 2);
            model.setRadius(radius);
            int halfWidth = model.getImageIcon().getIconWidth() / 2;
            int halfHeight = model.getImageIcon().getIconHeight() / 2;
            g.drawImage(model.getImageIcon().getImage(), (int)(radius + (radius - halfWidth) * Math.cos(model.getAngle()) - halfWidth), (int)(radius - (radius - halfHeight) * Math.sin(model.getAngle()) - halfHeight), null);
        }
    }
    private void addComponents(){
        JPanel centerPanel = new JPanel(new GridLayout(4, 1));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN));
        JButton chooseImageButton = new JButton("Выбрать");
        chooseImageButton.addMouseListener(new ChooseButtonListener(this, this.model));
        centerPanel.add(chooseImageButton);
        JButton startButton = new JButton("Старт");
        startButton.addMouseListener(new StartButtonListener(this));
        centerPanel.add(startButton);
        JSlider speedSlider = new JSlider();
        speedSlider.setOrientation(JSlider.HORIZONTAL);
        speedSlider.setMajorTickSpacing(50);
        speedSlider.setMinorTickSpacing(10);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        model.setSpeed(speedSlider.getValue());
        speedSlider.addChangeListener(new SliderListener(this.model));
        centerPanel.add(speedSlider);
        addRadioButtons(centerPanel);
        this.add(centerPanel, BorderLayout.CENTER);
    }
    private void addRadioButtons(JPanel panel){
        ButtonGroup group = new ButtonGroup();
        JRadioButton clockwise = new JRadioButton("По часовой");
        clockwise.setSelected(true);
        clockwise.addItemListener(new RadioButtonListener(this.model));
        model.setDirection(Direction.CLOCKWISE);
        JRadioButton counterClockwise = new JRadioButton("Против часовой");
        counterClockwise.addItemListener(new RadioButtonListener(this.model));
        group.add(clockwise);
        group.add(counterClockwise);
        JPanel radioButtonPanel = new JPanel(new GridLayout(1, 2));
        radioButtonPanel.add(clockwise);
        radioButtonPanel.add(counterClockwise);
        panel.add(radioButtonPanel);
    }
    private static class ChooseButtonListener extends MouseAdapter{
        private final Model model;
        private final CustomPanel panel;
        public ChooseButtonListener(CustomPanel panel, Model model){
            this.panel = panel;
            this.model = model;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            JFileChooser chooser = new JFileChooser();
            int res = chooser.showOpenDialog(null);
            if (res == JFileChooser.APPROVE_OPTION){
                File targetFile = chooser.getSelectedFile();
                model.setImageIcon(new ImageIcon(targetFile.getPath()));
                panel.repaint();
            }
        }
    }
    private static class SliderListener implements ChangeListener{
        private final Model model;
        public SliderListener(Model model){
            this.model = model;
        }
        @Override
        public void stateChanged(ChangeEvent e) {
            int value = ((JSlider)e.getSource()).getValue();
            model.setSpeed(value);
        }
    }
    private static class StartButtonListener extends MouseAdapter {
        private final CustomPanel panel;
        public StartButtonListener(CustomPanel panel){
            this.panel = panel;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Старт")) {
                panel.timer.start();
                button.setText("Стоп");
            } else {
                panel.timer.stop();
                button.setText("Старт");
            }

        }
    }
    private static class TimerListener implements ActionListener{
        private final Model model;
        private final CustomPanel panel;
        public TimerListener(Model model, CustomPanel panel){
            this.model = model;
            this.panel = panel;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Timer timer = (Timer)e.getSource();
            if (model.getAngle() < 0){
                model.setAngle(2 * Math.PI);
            }
            if (model.getAngle() > 2 * Math.PI){
                model.setAngle(0.0);
            }
            if (model.getDirection() == Direction.CLOCKWISE){
                model.setAngle(model.getAngle() - model.getAngularVelocity() * ((double)timer.getDelay() / 1000));
            }else{
                model.setAngle(model.getAngle() + model.getAngularVelocity() * ((double)timer.getDelay() / 1000));
            }

            panel.repaint();
        }
    }
    private static class RadioButtonListener implements ItemListener{

        private final Model model;
        public RadioButtonListener(Model model){
            this.model = model;
        }
        @Override
        public void itemStateChanged(ItemEvent e) {
            JRadioButton button = (JRadioButton)e.getSource();
            if (button.getText().equals("По часовой")){
                model.setDirection(Direction.CLOCKWISE);
            }else{
                model.setDirection(Direction.COUNTERCLOCKWISE);
            }
        }
    }
}
