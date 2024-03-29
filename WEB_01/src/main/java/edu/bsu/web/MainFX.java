package edu.bsu.web;

import edu.bsu.web.handler.AddResidentOptionsEventHandler;
import edu.bsu.web.handler.CountResidentsHandler;
import edu.bsu.web.handler.DeleteResidentOptionsEventHandler;
import edu.bsu.web.handler.GetAllResidentsEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class MainFX extends Application {

    private static final String RESOURCE_FILE = "\\application.properties";

    private static final String GRID_PANE_ID = "application.gridpane.id";

    private static final String ADD_RESIDENT_BUTTON_NAME = "application.addresident.button.name";
    private static final String COUNT_RESIDENTS_BUTTON = "application.countresidets.button.name";
    private static final String GET_ALL_RESIDENTS_BUTTON = "application.getallresidents.button.name";
    private static final String DELETE_RESIDENT_BUTTON = "application.deleteresident.button.name";

    public static final Properties PROPERTIES = new Properties();

    static {
        try(InputStream stream = MainFX.class.getClassLoader().getResourceAsStream(RESOURCE_FILE)){
            PROPERTIES.load(stream);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong...");
            alert.show();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(15, 12, 15, 12));

        GridPane gridPane = new GridPane();
        gridPane.setId(PROPERTIES.getProperty(GRID_PANE_ID));
        gridPane.setPadding(new Insets(15, 12, 15, 12));
        gridPane.setVgap(20);
        gridPane.setHgap(20);

        Button addResidentButton = new Button(PROPERTIES.getProperty(ADD_RESIDENT_BUTTON_NAME));
        addResidentButton.setOnAction(new AddResidentOptionsEventHandler(scene));
        Button countResidentsButton = new Button(PROPERTIES.getProperty(COUNT_RESIDENTS_BUTTON));
        countResidentsButton.setOnAction(new CountResidentsHandler());
        Button getAllResidentsButton = new Button(PROPERTIES.getProperty(GET_ALL_RESIDENTS_BUTTON));
        getAllResidentsButton.setOnAction(new GetAllResidentsEventHandler());
        Button deleteResidentButton = new Button(PROPERTIES.getProperty(DELETE_RESIDENT_BUTTON));
        deleteResidentButton.setOnAction(new DeleteResidentOptionsEventHandler(scene));

        hBox.getChildren().add(addResidentButton);
        hBox.getChildren().add(countResidentsButton);
        hBox.getChildren().add(getAllResidentsButton);
        hBox.getChildren().add(deleteResidentButton);

        borderPane.setTop(hBox);
        borderPane.setCenter(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
