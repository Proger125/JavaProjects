package main.java.edu.bsu.shapes.swing.config;

import main.java.edu.bsu.shapes.swing.listener.*;
import main.java.edu.bsu.shapes.swing.panel.*;

import javax.swing.*;
import java.awt.event.ActionListener;

public final class AllItems {

    public static final JButton DRAW_BUTTON = new JButton(ButtonName.DRAW_BUTTON);
    public static final JButton CLEAN_BUTTON = new JButton(ButtonName.CLEAN_BUTTON);

    public static final JRadioButton BORDER_COLOR_BUTTON = new JRadioButton(ButtonName.BORDER_COLOR_BUTTON);
    public static final JRadioButton FILL_COLOR_BUTTON = new JRadioButton(ButtonName.FILL_COLOR_BUTTON);

    public static final JRadioButton SEGMENT_BUTTON = new JRadioButton(ButtonName.SEGMENT_BUTTON_NAME);
    public static final JRadioButton RAY_BUTTON = new JRadioButton(ButtonName.RAY_BUTTON_NAME);
    public static final JRadioButton LINE_BUTTON = new JRadioButton(ButtonName.LINE_BUTTON_NAME);
    public static final JRadioButton TRIANGLE_BUTTON = new JRadioButton(ButtonName.TRIANGLE_BUTTON_NAME);
    public static final JRadioButton RECTANGLE_BUTTON = new JRadioButton(ButtonName.RECTANGLE_BUTTON_NAME);
    public static final JRadioButton ELLIPSE_BUTTON = new JRadioButton(ButtonName.ELLIPSE_BUTTON_NAME);
    public static final JRadioButton POLYGON_BUTTON = new JRadioButton(ButtonName.POLYGON_BUTTON_NAME);

    public static final JLabel FIRST_POINT_X_LABEL = new JLabel("X координата первой точки:");
    public static final JLabel FIRST_POINT_Y_LABEL = new JLabel("Y координата первой точки:");
    public static final JLabel SECOND_POINT_X_LABEL = new JLabel("X координата второй точки:");
    public static final JLabel SECOND_POINT_Y_LABEL = new JLabel("Y координата второй точки:");
    public static final JLabel THIRD_POINT_X_LABEL = new JLabel("X координата третьей точки:");
    public static final JLabel THIRD_POINT_Y_LABEL = new JLabel("Y координата третьей точки:");
    public static final JLabel FOURTH_POINT_X_LABEL = new JLabel("Х координата четвёртой точки:");
    public static final JLabel FOURTH_POINT_Y_LABEL = new JLabel("Y координата четвёртой точки:");

    public static final JLabel CENTER_POINT_X_LABEL = new JLabel("X координата центра:");
    public static final JLabel CENTER_POINT_Y_LABEL = new JLabel("Y координата центра:");

    public static final JLabel RADIUS_LABEL = new JLabel("Расстояние от центра до угла:");
    public static final JLabel HORIZONTAL_RADIUS_LABEL = new JLabel("Горизонтальный радиус:");
    public static final JLabel VERTICAL_RADIUS_LABEL = new JLabel("Вертикальный радиус:");

    public static final JLabel ANGLE_AMOUNT_LABEL = new JLabel("Кол-во углов:");

    public static final JLabel RED_COLOR_LABEL = new JLabel("Красный цвет:");
    public static final JLabel GREEN_COLOR_LABEL = new JLabel("Зелёный цвет:");
    public static final JLabel BLUE_COLOR_LABEL = new JLabel("Голубой цвет:");

    public static final JTextField FIRST_POINT_X_FIELD = new JTextField();
    public static final JTextField FIRST_POINT_Y_FIELD = new JTextField();
    public static final JTextField SECOND_POINT_X_FIELD = new JTextField();
    public static final JTextField SECOND_POINT_Y_FIELD = new JTextField();
    public static final JTextField THIRD_POINT_X_FIELD = new JTextField();
    public static final JTextField THIRD_POINT_Y_FIELD = new JTextField();
    public static final JTextField FOURTH_POINT_X_FIELD = new JTextField();
    public static final JTextField FOURTH_POINT_Y_FIELD = new JTextField();

    public static final JTextField CENTER_POINT_X_FIELD = new JTextField();
    public static final JTextField CENTER_POINT_Y_FIELD = new JTextField();

    public static final JTextField RADIUS_FIELD = new JTextField();
    public static final JTextField HORIZONTAL_RADIUS_FIELD = new JTextField();
    public static final JTextField VERTICAL_RADIUS_FIELD = new JTextField();

    public static final JTextField ANGLE_AMOUNT_FIELD = new JTextField();

    public static final JTextField RED_COLOR_FIELD = new JTextField();
    public static final JTextField GREEN_COLOR_FIELD = new JTextField();
    public static final JTextField BLUE_COLOR_FIELD = new JTextField();

    public static final ListPanel LIST_PANEL = new ListPanel();
    public static final OptionsPanel OPTIONS_PANEL = new OptionsPanel();
    public static final DrawPanel DRAW_PANEL = new DrawPanel();
    public static final PalettePanel PALETTE_PANEL = new PalettePanel();
    public static final ColorPanel COLOR_PANEL = new ColorPanel();
    public static final ButtonPanel BUTTON_PANEL = new ButtonPanel();
    public static final MainPanel MAIN_PANEL = new MainPanel();

    private static final ActionListener DRAW_LISTENER = new DrawListener();
    private static final ActionListener SELECT_ITEM_LISTENER = new SelectListItemListener();
    private static final ActionListener CHANGE_COLOR_LISTENER = new ChangeColorListener();
    private static final ActionListener CLEAN_DRAW_PANEL_LISTENER = new CleanDrawPanelListener();
    private static final ActionListener CHANGE_COLOR_STATE_LISTENER = new ChangeColorStateListener();

    static {
        SEGMENT_BUTTON.addActionListener(SELECT_ITEM_LISTENER);
        LINE_BUTTON.addActionListener(SELECT_ITEM_LISTENER);
        RAY_BUTTON.addActionListener(SELECT_ITEM_LISTENER);
        TRIANGLE_BUTTON.addActionListener(SELECT_ITEM_LISTENER);
        RECTANGLE_BUTTON.addActionListener(SELECT_ITEM_LISTENER);
        ELLIPSE_BUTTON.addActionListener(SELECT_ITEM_LISTENER);
        POLYGON_BUTTON.addActionListener(SELECT_ITEM_LISTENER);

        DRAW_BUTTON.setEnabled(false);
        DRAW_BUTTON.addActionListener(DRAW_LISTENER);
        CLEAN_BUTTON.addActionListener(CLEAN_DRAW_PANEL_LISTENER);

        FILL_COLOR_BUTTON.addActionListener(CHANGE_COLOR_STATE_LISTENER);
        BORDER_COLOR_BUTTON.addActionListener(CHANGE_COLOR_STATE_LISTENER);

        FIRST_POINT_X_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        FIRST_POINT_Y_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        SECOND_POINT_X_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        SECOND_POINT_Y_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        THIRD_POINT_X_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        THIRD_POINT_Y_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        FOURTH_POINT_X_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        FOURTH_POINT_Y_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        CENTER_POINT_X_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        CENTER_POINT_Y_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        HORIZONTAL_RADIUS_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        VERTICAL_RADIUS_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        RADIUS_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        ANGLE_AMOUNT_LABEL.setHorizontalAlignment(SwingConstants.CENTER);

        RED_COLOR_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        GREEN_COLOR_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        BLUE_COLOR_LABEL.setHorizontalAlignment(SwingConstants.CENTER);

        RED_COLOR_FIELD.setText("0");
        RED_COLOR_FIELD.addActionListener(CHANGE_COLOR_LISTENER);
        GREEN_COLOR_FIELD.setText("0");
        GREEN_COLOR_FIELD.addActionListener(CHANGE_COLOR_LISTENER);
        BLUE_COLOR_FIELD.setText("0");
        BLUE_COLOR_FIELD.addActionListener(CHANGE_COLOR_LISTENER);
    }

    private AllItems() {}
}
