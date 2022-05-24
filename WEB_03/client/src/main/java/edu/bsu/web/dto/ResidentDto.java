package edu.bsu.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Dto class for resident
 * @author Aleksandr_Dzyachenka
 */
@Data
public class ResidentDto implements Serializable {

    /**
     * Residents first name
     */
    private String firstName;

    /**
     * Residents last name
     */
    private String lastName;

    /**
     * Residents city
     */
    private String city;

    /**
     * Residents street
     */
    private String street;

    /**
     * Residents house number
     */
    private int houseNumber;
}
