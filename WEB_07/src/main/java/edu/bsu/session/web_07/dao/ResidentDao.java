package edu.bsu.session.web_07.dao;

import edu.bsu.session.web_07.dto.ResidentDto;
import edu.bsu.session.web_07.entity.Resident;
import edu.bsu.session.web_07.exception.DaoException;
import edu.bsu.session.web_07.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Map;

public interface ResidentDao {

    Resident addResident(ResidentDto dto) throws DaoException;

    Map<String, Integer> countResidentsInCities() throws DaoException;

    List<Resident> getAll() throws DaoException;

    void deleteByParameters(String firstName, String lastName) throws DaoException, ResourceNotFoundException;
}
