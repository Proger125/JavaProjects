package edu.bsu.web.handler;

import edu.bsu.web.dao.ResidentDao;
import edu.bsu.web.entity.Resident;
import edu.bsu.web.exception.DaoException;
import edu.bsu.web.handler.util.DrawResidentsUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import java.util.List;

/**
 * Event handler for handling get all residents request
 * @author Aleksandr_Dzyachenka
 */
public record GetAllResidentsEventHandler(ResidentDao residentDao,
                                          Scene scene) implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            List<Resident> residents = residentDao.getAll();
            DrawResidentsUtil.drawResidents(residents, scene);
        } catch (DaoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong...");
            alert.show();
        }
    }
}
