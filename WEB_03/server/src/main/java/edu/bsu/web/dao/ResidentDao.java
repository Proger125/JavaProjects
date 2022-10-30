package edu.bsu.web.dao;

import edu.bsu.web.dto.ResidentDto;
import edu.bsu.web.entity.Resident;
import edu.bsu.web.exception.DaoException;
import edu.bsu.web.exception.ResourceNotFoundException;

import javax.xml.bind.JAXBException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;


/**
 * Resident Dao interface with business functionality for RMI app
 * @author Aleksandr_Dzyachenka
 */
public interface ResidentDao extends Remote {

    /**
     * Add resident
     *
     * @param dto - resident dto
     * @return added to storage resident
     * @throws DaoException when implementation is incorrect
     * @throws RemoteException when RMI errors occur
     */
    Resident addResident(ResidentDto dto) throws DaoException, RemoteException;

    /**
     * Count how many residents live in each city
     *
     * @return {@link Map} with cities as key and residents amount as value
     * @throws DaoException when implementation is incorrect
     * @throws RemoteException when RMI errors occur
     */
    Map<String, Integer> countResidentsInCities() throws DaoException, RemoteException;

    /**
     * Get all residents
     *
     * @return All residents {@link List}
     * @throws DaoException occurs when implementation is incorrect
     * @throws RemoteException when RMI errors occur
     * @throws JAXBException when JAXB errors occur
     */
    List<Resident> getAll() throws DaoException, RemoteException, JAXBException;

    /**
     * Delete resident by params: <ul>
     *     <li>
     *     first name
     *      </li>
     *      <li>
     *      last name
     *      </li>
     * </ul>
     *
     * @param firstName residents first name
     * @param lastName residents last name
     * @throws DaoException when implementation is incorrect
     * @throws ResourceNotFoundException when no such user in the storage
     * @throws RemoteException when RMI errors occurs
     */
    void deleteByParameters(String firstName, String lastName) throws DaoException, ResourceNotFoundException, RemoteException;
}
