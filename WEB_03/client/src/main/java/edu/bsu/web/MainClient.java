package edu.bsu.web;

import edu.bsu.web.dao.ResidentDao;
import edu.bsu.web.handler.AddResidentOptionsEventHandler;
import edu.bsu.web.handler.CountResidentsHandler;
import edu.bsu.web.handler.DeleteResidentOptionsEventHandler;
import edu.bsu.web.handler.GetAllResidentsEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

/**
 * Main clients class
 * @author Aleksandr_Dzyachenka
 */
public class MainClient extends Application {

    private static final String UNIQUE_BINDING_NAME = "resident_dao";

    private static final String RESOURCE_FILE = "\\application.properties";

    private static final String GRID_PANE_ID = "application.gridpane.id";

    private static final String ADD_RESIDENT_BUTTON_NAME = "application.addresident.button.name";
    private static final String COUNT_RESIDENTS_BUTTON = "application.countresidets.button.name";
    private static final String GET_ALL_RESIDENTS_BUTTON = "application.getallresidents.button.name";
    private static final String DELETE_RESIDENT_BUTTON = "application.deleteresident.button.name";

    /**
     * Object with all javafx properties
     */
    public static final Properties PROPERTIES = new Properties();

    static {
        try(InputStream stream = MainClient.class.getClassLoader().getResourceAsStream(RESOURCE_FILE)){
            PROPERTIES.load(stream);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong...");
            alert.show();
        }
    }

    /**
     * Main clients method
     * @param args - command line args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws RemoteException, NotBoundException {
        final Registry registry = LocateRegistry.getRegistry(2732);
        final ResidentDao residentDao = (ResidentDao) registry.lookup(UNIQUE_BINDING_NAME);

        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(15, 12, 15, 12));

        GridPane gridPane = new GridPane();
        gridPane.setId(PROPERTIES.getProperty(GRID_PANE_ID));
        gridPane.setPadding(new Insets(15, 12, 15, 12));

        ScrollPane scrollPane = new ScrollPane(gridPane);
        Button addResidentButton = new Button(PROPERTIES.getProperty(ADD_RESIDENT_BUTTON_NAME));
        addResidentButton.setOnAction(new AddResidentOptionsEventHandler(scene, residentDao));
        Button countResidentsButton = new Button(PROPERTIES.getProperty(COUNT_RESIDENTS_BUTTON));
        countResidentsButton.setOnAction(new CountResidentsHandler(residentDao));
        Button getAllResidentsButton = new Button(PROPERTIES.getProperty(GET_ALL_RESIDENTS_BUTTON));
        getAllResidentsButton.setOnAction(new GetAllResidentsEventHandler(residentDao, scene));
        Button deleteResidentButton = new Button(PROPERTIES.getProperty(DELETE_RESIDENT_BUTTON));
        deleteResidentButton.setOnAction(new DeleteResidentOptionsEventHandler(scene, residentDao));

        hBox.getChildren().add(addResidentButton);
        hBox.getChildren().add(countResidentsButton);
        hBox.getChildren().add(getAllResidentsButton);
        hBox.getChildren().add(deleteResidentButton);

        borderPane.setTop(hBox);
        borderPane.setCenter(scrollPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
