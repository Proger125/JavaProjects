package edu.bsu.web.converter;

import edu.bsu.web.dto.ResidentDto;
import edu.bsu.web.entity.Address;
import edu.bsu.web.entity.Resident;

/**
 * @author Aleksandr_Dzyachenka
 * Class which converts residents
 */
public class ResidentConverter {

    /**
     * Converts resident dto to resident entity
     * @param dto - resident dto
     * @return converted resident
     */
    public Resident toResident(ResidentDto dto) {
        Resident resident = new Resident();
        resident.setFirstName(dto.getFirstName());
        resident.setLastName(dto.getLastName());
        Address address = new Address();
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHouseNumber(dto.getHouseNumber());
        resident.setAddress(address);
        return resident;
    }
}
