package edu.bsu.web.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Entity class for resident
 * @author Aleksandr_Dzyachenka
 */
@Data
@Builder
public class Resident implements Serializable {

    /**
     * Residents id
     */
    private Long id;

    /**
     * Residents first name
     */
    private String firstName;

    /**
     * Residents last name
     */
    private String lastName;

    /**
     * Residents address
     */
    private Address address;
}
