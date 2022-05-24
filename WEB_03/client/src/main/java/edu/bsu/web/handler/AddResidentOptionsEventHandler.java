package edu.bsu.web.handler;

import edu.bsu.web.dao.ResidentDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import static edu.bsu.web.MainClient.PROPERTIES;

/**
 * Event handler for creating form for add resident request options
 * @author Aleksandr_Dzyachenka
 */
public record AddResidentOptionsEventHandler(Scene scene,
                                             ResidentDao residentDao) implements EventHandler<ActionEvent> {
    private static final String GRID_PANE_ID = "application.gridpane.id";

    /**
     * ID of label for first name
     */
    public static final String FIRST_NAME_FIELD_ID = "application.addresident.firstname.field.id";
    /**
     * ID of label for last name
     */
    public static final String LAST_NAME_FIELD_ID = "application.addresident.lastname.field.id";
    /**
     * ID of label for city
     */
    public static final String CITY_FIELD_ID = "application.addresident.city.field.id";
    /**
     * ID of label for street
     */
    public static final String STREET_FIELD_ID = "application.addresident.street.field.id";
    /**
     * ID of label house number
     */
    public static final String HOUSE_NUMBER_FIELD_ID = "application.addresident.housenumber.field.id";

    private static final String FIRST_NAME_LABEL = "application.addresident.firstname.label";
    private static final String LAST_NAME_LABEL = "application.addresident.lastname.label";
    private static final String CITY_LABEL = "application.addresident.city.label";
    private static final String STREET_LABEL = "application.addresident.street.label";
    private static final String HOUSE_NUMBER_LABEL = "application.addresident.housenumber.label";

    private static final String ADD_BUTTON_NAME = "application.addresident.addbutton.name";

    @Override
    public void handle(ActionEvent event) {
        GridPane gridPane = (GridPane) scene.lookup("#" + PROPERTIES.getProperty(GRID_PANE_ID));
        gridPane.getChildren().clear();

        Label firstNameLabel = new Label(PROPERTIES.getProperty(FIRST_NAME_LABEL));
        Label lastNameLabel = new Label(PROPERTIES.getProperty(LAST_NAME_LABEL));
        Label cityLabel = new Label(PROPERTIES.getProperty(CITY_LABEL));
        Label streetLabel = new Label(PROPERTIES.getProperty(STREET_LABEL));
        Label houseNumberLabel = new Label(PROPERTIES.getProperty(HOUSE_NUMBER_LABEL));

        TextField firstNameField = new TextField();
        firstNameField.setId(PROPERTIES.getProperty(FIRST_NAME_FIELD_ID));

        TextField lastNameField = new TextField();
        lastNameField.setId(PROPERTIES.getProperty(LAST_NAME_FIELD_ID));

        TextField cityField = new TextField();
        cityField.setId(PROPERTIES.getProperty(CITY_FIELD_ID));

        TextField streetField = new TextField();
        streetField.setId(PROPERTIES.getProperty(STREET_FIELD_ID));

        TextField houseNumberField = new TextField();
        houseNumberField.setId(PROPERTIES.getProperty(HOUSE_NUMBER_FIELD_ID));

        Button addButton = new Button(PROPERTIES.getProperty(ADD_BUTTON_NAME));
        addButton.setOnAction(new AddResidentEventHandler(scene, residentDao));


        gridPane.add(firstNameLabel, 0, 0);
        gridPane.add(firstNameField, 1, 0);

        gridPane.add(lastNameLabel, 0, 1);
        gridPane.add(lastNameField, 1, 1);

        gridPane.add(cityLabel, 0, 2);
        gridPane.add(cityField, 1, 2);

        gridPane.add(streetLabel, 0, 3);
        gridPane.add(streetField, 1, 3);

        gridPane.add(houseNumberLabel, 0, 4);
        gridPane.add(houseNumberField, 1, 4);

        gridPane.add(addButton, 2, 2);
    }
}
