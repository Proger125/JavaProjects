package edu.bsu.web.handler;

import edu.bsu.web.dao.ResidentDao;
import edu.bsu.web.entity.Resident;
import edu.bsu.web.exception.DaoException;
import edu.bsu.web.exception.ResourceNotFoundException;
import edu.bsu.web.handler.util.DrawResidentsUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.List;

import static edu.bsu.web.MainClient.PROPERTIES;
import static edu.bsu.web.handler.AddResidentOptionsEventHandler.FIRST_NAME_FIELD_ID;
import static edu.bsu.web.handler.AddResidentOptionsEventHandler.LAST_NAME_FIELD_ID;

/**
 * Event handler for handling delete resident request
 * @author Aleksandr_Dzyachenka
 */
public record DeleteResidentEventHandler(Scene scene,
                                         ResidentDao residentDao) implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        String firstName = ((TextField) scene.lookup("#" + PROPERTIES.getProperty(FIRST_NAME_FIELD_ID))).getText();
        String lastName = ((TextField) scene.lookup("#" + PROPERTIES.getProperty(LAST_NAME_FIELD_ID))).getText();
        try {
            residentDao.deleteByParameters(firstName, lastName);
            List<Resident> residents = residentDao.getAll();
            DrawResidentsUtil.drawResidents(residents, scene);
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
