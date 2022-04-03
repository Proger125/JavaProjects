package edu.bsu.web.handler;

import edu.bsu.web.dao.ResidentDao;
import edu.bsu.web.entity.Resident;
import edu.bsu.web.exception.DaoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.util.List;

public class GetAllResidentsEventHandler implements EventHandler<ActionEvent> {

    private final ResidentDao residentDao;

    public GetAllResidentsEventHandler(ResidentDao residentDao) {
        this.residentDao = residentDao;
    }

    @Override
    public void handle(ActionEvent event) {
        try{
            List<Resident> residents = residentDao.getAll();
            StringBuilder builder = new StringBuilder();
            residents.forEach(resident -> builder.append(resident.toString()).append("\n"));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("All residents");
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
