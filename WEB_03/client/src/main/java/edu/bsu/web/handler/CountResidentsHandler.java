package edu.bsu.web.handler;

import edu.bsu.web.dao.ResidentDao;
import edu.bsu.web.exception.DaoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.util.Map;

/**
 * Event handler for handling count residents request
 * @author Aleksandr_Dzyachenka
 */
public record CountResidentsHandler(ResidentDao residentDao) implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            Map<String, Integer> map = residentDao.countResidentsInCities();
            StringBuilder builder = new StringBuilder();
            for (var entry : map.entrySet()) {
                builder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("People amount in cities");
            alert.setContentText(builder.toString());
            alert.show();
        } catch (DaoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong...");
            alert.show();
        }
    }
}
