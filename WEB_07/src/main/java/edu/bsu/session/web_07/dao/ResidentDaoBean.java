package edu.bsu.session.web_07.dao;

import edu.bsu.session.web_07.dto.ResidentDto;
import edu.bsu.session.web_07.entity.Resident;
import edu.bsu.session.web_07.exception.DaoException;
import edu.bsu.session.web_07.exception.ResourceNotFoundException;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JavaBean
public class ResidentDaoBean {

    private List<Resident> residents;

    private ResidentDto residentDto;

    private Map<String, Integer> residentsInCities;

    private final ResidentDao residentDao;

    public ResidentDaoBean() {
        residents = new ArrayList<>();
        residentDto = new ResidentDto();
        residentsInCities = new HashMap<>();
        residentDao = new ResidentDaoImpl();
    }

    public List<Resident> getResidents() throws DaoException {
        return residentDao.getAll();
    }

    public Map<String, Integer> getResidentsInCities() throws DaoException {
        return residentDao.countResidentsInCities();
    }

    public ResidentDto getResidentDto() {
        return residentDto;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    public void setResidentDto(ResidentDto residentDto) throws DaoException, ResourceNotFoundException {
        this.residentDto = residentDto;
        if (residentDto.getCity() == null) {
            residentDao.deleteByParameters(residentDto.getFirstName(), residentDto.getLastName());
        } else {
            residentDao.addResident(residentDto);
        }

    }

    public void setResidentsInCities(Map<String, Integer> residentsInCities) {
        this.residentsInCities = residentsInCities;
    }
}
