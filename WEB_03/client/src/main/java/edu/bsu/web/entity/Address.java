package edu.bsu.web.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Entity class for address
 * @author Aleksandr_Dzyachenka
 */
@Data
@Builder
public class Address implements Serializable {

    /**
     * Address id
     */
    private Long id;

    /**
     * City
     */
    private String city;

    /**
     * Street
     */
    private String street;

    /**
     * House number
     */
    private int houseNumber;
}
