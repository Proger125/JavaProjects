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
import static edu.bsu.web.handler.AddResidentOptionsEventHandler.*;

/**
 * Event handler for creating form for delete resident request options all residents request
 * @author Aleksandr_Dzyachenka
 */
public record DeleteResidentOptionsEventHandler(Scene scene,
                                                ResidentDao residentDao) implements EventHandler<ActionEvent> {

    private static final String GRID_PANE_ID = "application.gridpane.id";
    private static final String FIRST_NAME_LABEL = "application.addresident.firstname.label";
    private static final String LAST_NAME_LABEL = "application.addresident.lastname.label";
    private static final String DELETE_RESIDENT_BUTTON = "application.deleteresident.button.name";


    @Override
    public void handle(ActionEvent event) {
        Label firstNameLabel = new Label(PROPERTIES.getProperty(FIRST_NAME_LABEL));
        TextField firstNameField = new TextField();
        firstNameField.setId(PROPERTIES.getProperty(FIRST_NAME_FIELD_ID));
        Label lastNameLabel = new Label(PROPERTIES.getProperty(LAST_NAME_LABEL));
        TextField lastNameField = new TextField();
        lastNameField.setId(PROPERTIES.getProperty(LAST_NAME_FIELD_ID));
        GridPane gridPane = (GridPane) scene.lookup("#" + PROPERTIES.getProperty(GRID_PANE_ID));
        gridPane.getChildren().clear();

        gridPane.add(firstNameLabel, 0, 0);
        gridPane.add(firstNameField, 1, 0);
        gridPane.add(lastNameLabel, 0, 1);
        gridPane.add(lastNameField, 1, 1);

        Button deleteButton = new Button(PROPERTIES.getProperty(DELETE_RESIDENT_BUTTON));
        deleteButton.setOnAction(new DeleteResidentEventHandler(scene, residentDao));
        gridPane.add(deleteButton, 1, 2);
    }
}
