package edu.bsu.web.handler.util;

import edu.bsu.web.entity.Resident;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.List;

import static edu.bsu.web.MainClient.PROPERTIES;

/**
 * Util class for drawing residents info on the application window
 * @author Aleksandr_Dzyachenka
 */
public final class DrawResidentsUtil {

    private static final String GRID_PANE_ID = "application.gridpane.id";

    private DrawResidentsUtil(){}

    /**
     * Draw residents on the application window
     * @param residents - residents to draw
     * @param scene - place to draw
     */
    public static void drawResidents(List<Resident> residents, Scene scene) {
        GridPane gridPane = (GridPane) scene.lookup("#" + PROPERTIES.getProperty(GRID_PANE_ID));
        gridPane.getChildren().clear();
        gridPane.addRow(0,
                createCustomLabel("Resident name"),
                createCustomLabel("City"),
                createCustomLabel("Street"),
                createCustomLabel("House number"));
        int i = 1;
        for (var resident : residents) {
            gridPane.addRow(i,
                    createCustomLabel(resident.getFirstName() + " " + resident.getLastName()),
                    createCustomLabel(resident.getAddress().getCity()),
                    createCustomLabel(resident.getAddress().getStreet()),
                    createCustomLabel(Integer.toString(resident.getAddress().getHouseNumber())));
            i++;
        }
    }

    private static GridPane createCustomLabel(String text) {
        GridPane gridPane = new GridPane();
        Label label = new Label(text);
        gridPane.addRow(0, label);
        gridPane.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(1))));
        gridPane.setPadding(new Insets(15, 12, 15, 12));
        return gridPane;
    }
}
