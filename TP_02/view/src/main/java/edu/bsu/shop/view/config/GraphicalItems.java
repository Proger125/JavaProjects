package edu.bsu.shop.view.config;

import edu.bsu.shop.listener.ChangeManagerPanelListener;
import edu.bsu.shop.listener.ManagerPanelType;
import edu.bsu.shop.view.CustomFrame;
import edu.bsu.shop.view.panel.LoginPanel;

import javax.swing.*;
import java.awt.*;

import static edu.bsu.shop.view.config.GraphicalConstants.*;
public final class GraphicalItems {
    public static final JLabel LOGIN_LABEL = new JLabel(LOGIN_LABEL_TITLE);
    public static final JTextField LOGIN_FIELD = new JTextField();

    public static final JLabel PASSWORD_LABEL = new JLabel(PASSWORD_LABEL_TITLE);
    public static final JPasswordField PASSWORD_FIELD = new JPasswordField();

    public static final JLabel PRODUCT_NAME_LABEL = new JLabel(PRODUCT_NAME_LABEL_TITLE);
    public static final JTextField PRODUCT_NAME_FIELD = new JTextField();

    public static final JLabel PRODUCT_DESCRIPTION_LABEL = new JLabel(PRODUCT_DESCRIPTION_LABEL_TITLE);
    public static final JTextArea PRODUCT_DESCRIPTION_AREA = new JTextArea();

    public static final JLabel PRODUCT_COST_LABEL = new JLabel(PRODUCT_COST_LABEL_TITLE);
    public static final JTextField PRODUCT_COST_FIELD = new JTextField();

    public static final JButton LOGIN_BUTTON = new JButton(LOGIN_BUTTON_TITLE);
    public static final JButton ORDER_BUTTON = new JButton(ORDER_BUTTON_TITLE);
    public static final JButton CHANGE_MANAGER_PANEL_BUTTON = new JButton(CHANGE_MANAGER_PANEL_BUTTON_TITLE);
    public static final JButton ADD_NEW_PRODUCT_BUTTON = new JButton(ADD_NEW_PRODUCT_BUTTON_TITLE);

    public static final JList<String> BASKET = new JList<>(ViewConfig.getInstance().getBasketModel());

    public static final JPanel LOGIN_PANEL = new LoginPanel();

    public static final JFrame MAIN_FRAME = new CustomFrame("Work Window");

    public static ChangeManagerPanelListener CHANGE_MANAGER_PANEL_LISTENER = new ChangeManagerPanelListener();

    static {
        LOGIN_LABEL.setSize(getTextAreaFixedSize());
        LOGIN_FIELD.setSize(getTextAreaFixedSize());
        PASSWORD_LABEL.setSize(getTextAreaFixedSize());
        PASSWORD_FIELD.setSize(getTextAreaFixedSize());

        PRODUCT_COST_FIELD.setSize(getTextAreaFixedSize());
        PRODUCT_COST_LABEL.setSize(getTextAreaFixedSize());
        PRODUCT_DESCRIPTION_LABEL.setSize(getTextAreaFixedSize());
        PRODUCT_NAME_FIELD.setSize(getTextAreaFixedSize());
        PRODUCT_NAME_LABEL.setSize(getTextAreaFixedSize());
        PRODUCT_DESCRIPTION_AREA.setSize(new Dimension(200, 250));
        PRODUCT_DESCRIPTION_AREA.setLineWrap(true);
        PRODUCT_DESCRIPTION_AREA.setWrapStyleWord(true);
        ADD_NEW_PRODUCT_BUTTON.setSize(new Dimension(150, 20));


        LOGIN_BUTTON.setSize(70, 20);
        CHANGE_MANAGER_PANEL_LISTENER.setType(ManagerPanelType.ADD_PRODUCT_PANEL);
    }

    public static void repaintFrame() {
        MAIN_FRAME.invalidate();
        MAIN_FRAME.validate();
        MAIN_FRAME.repaint();
    }

    public static Dimension getTextAreaFixedSize() {
        return new Dimension(120, 20);
    }

    public static Dimension getProductFixedSize() {
        return new Dimension(400, 80);
    }

    public static Dimension getOrderFixedSize() {
        return new Dimension(400, 200);
    }

    public static Dimension getButtonFixedSize() {
        return new Dimension(200, 20);
    }

}
