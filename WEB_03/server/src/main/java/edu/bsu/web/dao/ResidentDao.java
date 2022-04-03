package edu.bsu.web.dao;

import edu.bsu.web.dto.ResidentDto;
import edu.bsu.web.entity.Resident;
import edu.bsu.web.exception.DaoException;
import edu.bsu.web.exception.ResourceNotFoundException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface ResidentDao extends Remote {

    Resident addResident(ResidentDto dto) throws DaoException, RemoteException;

    Map<String, Integer> countResidentsInCities() throws DaoException, RemoteException;

    List<Resident> getAll() throws DaoException, RemoteException;

    void deleteByParameters(String firstName, String lastName) throws DaoException, ResourceNotFoundException, RemoteException;
}
