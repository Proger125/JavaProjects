package edu.bsu.web.dao;

import edu.bsu.web.dto.ResidentDto;
import edu.bsu.web.entity.Resident;
import edu.bsu.web.exception.DaoException;
import edu.bsu.web.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Map;

public interface ResidentDao {

    Resident addResident(ResidentDto dto) throws DaoException;

    Map<String, Integer> countResidentsInCities() throws DaoException;

    List<Resident> getAll() throws DaoException;

    void deleteById(Long id) throws DaoException, ResourceNotFoundException;
}
