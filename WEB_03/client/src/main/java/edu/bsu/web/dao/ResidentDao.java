package edu.bsu.web.dao;

import edu.bsu.web.dto.ResidentDto;
import edu.bsu.web.entity.Resident;
import edu.bsu.web.exception.DaoException;
import edu.bsu.web.exception.ResourceNotFoundException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

/**
 * Resident dao RMI interface
 * @author Aleksandr_Dzyachenka
 */
public interface ResidentDao extends Remote {

    /**
     * Add resident
     *
     * @param dto - resident dto
     * @return added to storage resident
     * @throws DaoException when implementation is incorrect
     */
    Resident addResident(ResidentDto dto) throws DaoException;

    /**
     * Count how many residents live in each city
     *
     * @return {@link Map} with cities as key and residents amount as value
     * @throws DaoException when implementation is incorrect
     */
    Map<String, Integer> countResidentsInCities() throws DaoException;

    /**
     * Get all residents
     *
     * @return All residents {@link List}
     * @throws DaoException occurs when implementation is incorrect
     */
    List<Resident> getAll() throws DaoException;

    /**
     * Delete resident by first name and last name.
     *
     * @param firstName residents first name
     * @param lastName residents last name
     * @throws DaoException when implementation is incorrect
     * @throws ResourceNotFoundException when no such user in the storage
     */
    void deleteByParameters(String firstName, String lastName) throws DaoException, ResourceNotFoundException;
}
