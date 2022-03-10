package main.java.edu.bsu.figures.swing.config;

import main.java.edu.bsu.figures.swing.listener.*;
import main.java.edu.bsu.figures.swing.panel.ButtonPanel;
import main.java.edu.bsu.figures.swing.panel.FigurePanel;
import main.java.edu.bsu.figures.swing.panel.MainPanel;
import main.java.edu.bsu.figures.swing.panel.OptionsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static main.java.edu.bsu.figures.swing.config.GraphicTitle.*;
public class Graphic {
    public static final JRadioButton SEGMENT_BUTTON = new JRadioButton(SEGMENT_BUTTON_NAME);
    public static final JRadioButton RAY_BUTTON = new JRadioButton(RAY_BUTTON_NAME);
    public static final JRadioButton LINE_BUTTON = new JRadioButton(LINE_BUTTON_NAME);
    public static final JRadioButton POLYGON_BUTTON = new JRadioButton(POLYGON_BUTTON_NAME);
    public static final JRadioButton REGULAR_POLYGON_BUTTON = new JRadioButton(REGULAR_POLYGON_BUTTON_NAME);
    public static final JRadioButton ELLIPSE_BUTTON = new JRadioButton(ELLIPSE_BUTTON_NAME);

    public static final JButton CHOOSE_BORDER_COLOR_BUTTON = new JButton(BORDER_COLOR_BUTTON_NAME);
    public static final JButton CHOOSE_FILL_COLOR_BUTTON = new JButton(FILL_COLOR_BUTTON_NAME);
    public static final JButton CLEAN_ALL_BUTTON = new JButton(CLEAN_ALL_BUTTON_NAME);

    public static final List<JLabel> POINTS_LABELS = new ArrayList<>();
    public static final List<JTextField> POINTS_FIELDS = new ArrayList<>();

    public static final JLabel CENTER_POINT_X_LABEL = new JLabel(CENTER_POINT_X_TITLE);
    public static final JLabel CENTER_POINT_Y_LABEL = new JLabel(CENTER_POINT_Y_TITLE);
    public static final JLabel RADIUS_LABEL = new JLabel(RADIUS_TITLE);
    public static final JLabel HORIZONTAL_RADIUS_LABEL = new JLabel(HORIZONTAL_RADIUS_TITLE);
    public static final JLabel VERTICAL_RADIUS_LABEL = new JLabel(VERTICAL_RADIUS_TITLE);
    public static final JLabel ANGLES_AMOUNT_LABEL = new JLabel(ANGLES_AMOUNT_TITLE);

    public static final JTextField CENTER_POINT_X_FIELD = new JTextField();
    public static final JTextField CENTER_POINT_Y_FIELD = new JTextField();
    public static final JTextField RADIUS_FIELD = new JTextField();
    public static final JTextField HORIZONTAL_RADIUS_FIELD = new JTextField();
    public static final JTextField VERTICAL_RADIUS_FIELD = new JTextField();
    public static final JTextField ANGLES_AMOUNT_FIELD = new JTextField();

    public static final JPanel OPTIONS_PANEL = new OptionsPanel();
    public static final JPanel FIGURE_PANEL = new FigurePanel();
    public static final JPanel DRAW_PANEL = new JPanel();
    public static final JPanel BUTTON_PANEL = new ButtonPanel();
    public static final JPanel MAIN_PANEL = new MainPanel();

    public static final JFrame OPTIONS_FRAME = new JFrame();

    public static final ActionListener SELECT_FIGURE_LISTENER = new SelectFigureListener();
    public static final ActionListener DRAW_BY_TWO_POINTS_LISTENER = new DrawByTwoPointsListener();
    public static final ActionListener DRAW_POLYGON_LISTENER = new DrawPolygonListener();
    public static final ActionListener DRAW_ELLIPSE_LISTENER = new DrawEllipseListener();
    public static final ActionListener DRAW_REGULAR_POLYGON_LISTENER = new DrawRegularPolygonListener();
    public static final ActionListener CHOOSE_COLOR_LISTENER = new ChooseColorListener();
    public static final ActionListener CLEAN_BUTTON_LISTENER = new CleanButtonListener();

    static {
        SEGMENT_BUTTON.addActionListener(SELECT_FIGURE_LISTENER);
        SEGMENT_BUTTON.setHorizontalAlignment(SwingConstants.CENTER);

        RAY_BUTTON.addActionListener(SELECT_FIGURE_LISTENER);
        RAY_BUTTON.setHorizontalAlignment(SwingConstants.CENTER);

        LINE_BUTTON.addActionListener(SELECT_FIGURE_LISTENER);
        LINE_BUTTON.setHorizontalAlignment(SwingConstants.CENTER);

        POLYGON_BUTTON.addActionListener(SELECT_FIGURE_LISTENER);
        POLYGON_BUTTON.setHorizontalAlignment(SwingConstants.CENTER);

        REGULAR_POLYGON_BUTTON.addActionListener(SELECT_FIGURE_LISTENER);
        REGULAR_POLYGON_BUTTON.setHorizontalAlignment(SwingConstants.CENTER);

        ELLIPSE_BUTTON.addActionListener(SELECT_FIGURE_LISTENER);
        ELLIPSE_BUTTON.setHorizontalAlignment(SwingConstants.CENTER);

        DRAW_PANEL.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        CHOOSE_BORDER_COLOR_BUTTON.addActionListener(CHOOSE_COLOR_LISTENER);
        CHOOSE_FILL_COLOR_BUTTON.addActionListener(CHOOSE_COLOR_LISTENER);
        CLEAN_ALL_BUTTON.addActionListener(CLEAN_BUTTON_LISTENER);
    }
}
