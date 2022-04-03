package edu.bsu.web.handler;

import edu.bsu.web.dao.ResidentDao;
import edu.bsu.web.dao.ResidentDaoImpl;
import edu.bsu.web.exception.DaoException;
import edu.bsu.web.exception.ResourceNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import static edu.bsu.web.MainFX.PROPERTIES;
import static edu.bsu.web.handler.AddResidentOptionsEventHandler.FIRST_NAME_FIELD_ID;
import static edu.bsu.web.handler.AddResidentOptionsEventHandler.LAST_NAME_FIELD_ID;

public class DeleteResidentEventHandler implements EventHandler<ActionEvent> {

    private final Scene scene;
    private final ResidentDao residentDao = new ResidentDaoImpl();

    public DeleteResidentEventHandler(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void handle(ActionEvent event) {
        String firstName = ((TextField) scene.lookup("#" + PROPERTIES.getProperty(FIRST_NAME_FIELD_ID))).getText();
        String lastName = ((TextField) scene.lookup("#" + PROPERTIES.getProperty(LAST_NAME_FIELD_ID))).getText();
        try {
            residentDao.deleteByParameters(firstName, lastName);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Resident was successfully deleted");
            alert.show();
        } catch (DaoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong...");
            alert.show();
        } catch (ResourceNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No such resident");
            alert.show();
        }
    }
}
