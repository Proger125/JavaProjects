package edu.bsu.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * Entity class for address
 * @author Aleksandr Dzyachenka
 * @see java.io.Serializable
 */
@Data
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address implements Serializable{

    /**
     * Util constant for correct serializing
     */
    @Serial
    private static final long serialVersionUID = -7790215461124551437L;

    /**
     * Address id
     */
    private Long id;

    /**
     * City
     */
    @XmlElement(name = "city")
    private String city;

    /**
     * Street
     */
    @XmlElement(name = "street")
    private String street;

    /**
     * House number
     */
    @XmlElement(name = "house-number")
    private int houseNumber;
}
