package edu.bsu.web.dao.impl;

import edu.bsu.web.converter.ResidentConverter;
import edu.bsu.web.dao.ResidentDao;
import edu.bsu.web.dto.ResidentDto;
import edu.bsu.web.entity.Address;
import edu.bsu.web.entity.Resident;
import edu.bsu.web.exception.DaoException;
import edu.bsu.web.exception.ResourceNotFoundException;

import javax.xml.stream.*;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link ResidentDao} which uses STAX technology to work with xml
 */
public class ResidentDaoStaxImpl implements ResidentDao {

    private static final String FILE_NAME = "server/src/main/resources/residents.xml";

    private final ResidentConverter converter = new ResidentConverter();

    @Override
    public Resident addResident(ResidentDto dto) throws DaoException, RemoteException {
        List<Resident> residents = getAll();
        Resident resident = converter.toResident(dto);
        residents.add(resident);
        writeResidents(residents);
        return resident;
    }

    @Override
    public Map<String, Integer> countResidentsInCities() throws DaoException, RemoteException {
        Map<String, Integer> cities = new HashMap<>();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(FILE_NAME));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("city")) {
                        xmlEvent = reader.nextEvent();
                        String city = xmlEvent.asCharacters().getData();
                        if (cities.containsKey(city)) {
                            cities.put(city, cities.get(city) + 1);
                        } else {
                            cities.put(city, 1);
                        }
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new DaoException("Something went wrong");
        } catch (FileNotFoundException e) {
            throw new DaoException("XML file wasn't found");
        }
        return cities;
    }

    @Override
    public List<Resident> getAll() throws DaoException, RemoteException {
        List<Resident> residents = new ArrayList<>();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        Resident resident = null;
        Address address = null;
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(FILE_NAME));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    String startElementName = startElement.getName().getLocalPart();
                    switch (startElementName) {
                        case "resident" -> resident = new Resident();
                        case "first-name" -> {
                            xmlEvent = reader.nextEvent();
                            if (resident != null) {
                                resident.setFirstName(xmlEvent.asCharacters().getData());
                            } else {
                                throw new DaoException("Incorrect xml file");
                            }
                        }
                        case "last-name" -> {
                            xmlEvent = reader.nextEvent();
                            if (resident != null) {
                                resident.setLastName(xmlEvent.asCharacters().getData());
                            } else {
                                throw new DaoException("Incorrect xml file");
                            }
                        }
                        case "address" -> address = new Address();
                        case "city" -> {
                            xmlEvent = reader.nextEvent();
                            if (address != null) {
                                address.setCity(xmlEvent.asCharacters().getData());
                            } else {
                                throw new DaoException("Incorrect xml file");
                            }
                        }
                        case "street" -> {
                            xmlEvent = reader.nextEvent();
                            if (address != null) {
                                address.setStreet(xmlEvent.asCharacters().getData());
                            } else {
                                throw new DaoException("Incorrect xml file");
                            }
                        }
                        case "house-number" -> {
                            xmlEvent = reader.nextEvent();
                            if (address != null) {
                                address.setHouseNumber(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            } else {
                                throw new DaoException("Incorrect xml file");
                            }
                        }
                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    String endElementName = endElement.getName().getLocalPart();
                    if (endElementName.equals("address")) {
                        if (resident != null && address != null) {
                            resident.setAddress(address);
                        }
                    } else if (endElementName.equals("resident")) {
                        if (resident != null) {
                            residents.add(resident);
                        }
                    }
                }
            }
            return residents;
        } catch (XMLStreamException e) {
            throw new DaoException("Something went wrong");
        } catch (FileNotFoundException e) {
            throw new DaoException("XML file wasn't found");
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
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
        try {
            XMLStreamWriter writer = xmlOutputFactory.createXMLStreamWriter(new FileWriter(FILE_NAME));
            writer.writeStartDocument();
            writer.writeStartElement("residents");
            for (var resident : residents) {
                writer.writeStartElement("resident");

                writer.writeStartElement("first-name");
                writer.writeCharacters(resident.getFirstName());
                writer.writeEndElement();

                writer.writeStartElement("last-name");
                writer.writeCharacters(resident.getLastName());
                writer.writeEndElement();

                writer.writeStartElement("address");
                writer.writeStartElement("city");
                writer.writeCharacters(resident.getAddress().getCity());
                writer.writeEndElement();

                writer.writeStartElement("street");
                writer.writeCharacters(resident.getAddress().getStreet());
                writer.writeEndElement();

                writer.writeStartElement("house-number");
                writer.writeCharacters(Integer.toString(resident.getAddress().getHouseNumber()));
                writer.writeEndElement();
                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();

            writer.close();
        } catch (XMLStreamException e) {
            throw new DaoException("Something went wrong");
        } catch (IOException e) {
            throw new DaoException("XML file wasn't found");
        }
    }
}
