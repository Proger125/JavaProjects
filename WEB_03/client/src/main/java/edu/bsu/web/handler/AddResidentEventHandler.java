package edu.bsu.web.handler;

import edu.bsu.web.dao.ResidentDao;
import edu.bsu.web.dto.ResidentDto;
import edu.bsu.web.entity.Resident;
import edu.bsu.web.exception.DaoException;
import edu.bsu.web.handler.util.DrawResidentsUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.List;

import static edu.bsu.web.MainClient.PROPERTIES;
import static edu.bsu.web.handler.AddResidentOptionsEventHandler.*;

/**
 * Event handler for handling add resident request
 * @author Aleksandr_Dzyachenka
 */
public record AddResidentEventHandler(Scene scene,
                                      ResidentDao residentDao) implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        ResidentDto residentDto = new ResidentDto();
        String firstName = ((TextField) scene.lookup("#" + PROPERTIES.getProperty(FIRST_NAME_FIELD_ID))).getText();
        String lastName = ((TextField) scene.lookup("#" + PROPERTIES.getProperty(LAST_NAME_FIELD_ID))).getText();
        String city = ((TextField) scene.lookup("#" + PROPERTIES.getProperty(CITY_FIELD_ID))).getText();
        String street = ((TextField) scene.lookup("#" + PROPERTIES.getProperty(STREET_FIELD_ID))).getText();
        String houseNumberStr = ((TextField) scene.lookup("#" + PROPERTIES.getProperty(HOUSE_NUMBER_FIELD_ID))).getText();
        try {
            int houseNumber = Integer.parseInt(houseNumberStr);
            residentDto.setFirstName(firstName);
            residentDto.setLastName(lastName);
            residentDto.setCity(city);
            residentDto.setStreet(street);
            residentDto.setHouseNumber(houseNumber);
            Resident resident = residentDao.addResident(residentDto);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("User was successfully added");
            alert.setContentText(resident.getFirstName() + " " + resident.getLastName());

            List<Resident> residents = residentDao.getAll();
            DrawResidentsUtil.drawResidents(residents, scene);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Incorrect house number!");
            alert.show();
        } catch (DaoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong...");
            alert.show();
        }
    }
}
