package edu.bsu.web.dao.impl;

import edu.bsu.web.converter.ResidentConverter;
import edu.bsu.web.dao.ResidentDao;
import edu.bsu.web.dto.ResidentDto;
import edu.bsu.web.entity.Resident;
import edu.bsu.web.entity.Residents;
import edu.bsu.web.exception.DaoException;
import edu.bsu.web.exception.ResourceNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link ResidentDao} which uses JAXB technology to work with xml
 * @author Aleksandr_Dzyachenka
 */
public class ResidentDaoJaxbImpl implements ResidentDao {

    private static final String FILE_NAME = "server/src/main/resources/residents.xml";

    private final ResidentConverter converter = new ResidentConverter();

    @Override
    public Resident addResident(ResidentDto dto) throws DaoException, RemoteException {
        List<Resident> residents = new ArrayList<>(getAll());
        Resident resident = converter.toResident(dto);
        residents.add(resident);
        writeResidents(residents);
        return resident;
    }

    @Override
    public Map<String, Integer> countResidentsInCities() throws DaoException, RemoteException {
        List<Resident> residents = new ArrayList<>(getAll());
        Map<String, Integer> cities = new HashMap<>();
        for (var resident : residents) {
            String city = resident.getAddress().getCity();
            if (cities.containsKey(city)) {
                cities.put(city, cities.get(city) + 1);
            } else {
                cities.put(city, 1);
            }
        }
        return cities;
    }

    @Override
    public List<Resident> getAll() throws DaoException {
        try {
            JAXBContext jc = JAXBContext.newInstance(Residents.class);
            File file = new File(FILE_NAME);
            System.out.println(file.getAbsolutePath());
            Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();
            Residents residents = (Residents) jaxbUnmarshaller.unmarshal(file);
            return residents.getResidents() == null ? new ArrayList<>() : residents.getResidents();
        } catch (JAXBException e) {
            throw new DaoException("Something went wrong");
        }
    }

    @Override
    public void deleteByParameters(String firstName, String lastName) throws DaoException, ResourceNotFoundException, RemoteException {
        List<Resident> residents = getAll();
        Resident residentToDelete = null;
        for (var resident : residents) {
            if (resident.getFirstName().equals(firstName) && resident.getLastName().equals(lastName)) {
                residentToDelete = resident;
            }
        }
        if (residentToDelete != null) {
            residents.remove(residentToDelete);
        } else {
            throw new ResourceNotFoundException();
        }

        writeResidents(residents);
    }

    private void writeResidents(List<Resident> residents) throws DaoException {
        Residents res = new Residents();
        res.setResidents(residents);
        try {
            JAXBContext jc = JAXBContext.newInstance(Residents.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(res, new FileWriter(FILE_NAME));
        } catch (JAXBException | IOException e) {
            throw new DaoException("Something went wrong!");
        }
    }
}
