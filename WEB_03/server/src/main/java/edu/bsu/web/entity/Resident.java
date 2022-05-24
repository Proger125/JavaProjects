package edu.bsu.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * Entity class for resident
 * @see java.io.Serializable
 * @author Aleksandr Dzyachenka
 */
@Data
@NoArgsConstructor
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Resident implements Serializable {

    /**
     * Util constant for correct serializing
     */
    @Serial
    private static final long serialVersionUID = -933066477012072293L;

    /**
     * Resident id
     */
    private Long id;

    /**
     * Residents first name
     */
    @XmlElement(name = "first-name")
    private String firstName;

    /**
     * Residents last name
     */
    @XmlElement(name = "last-name")
    private String lastName;

    /**
     * Residents address
     */
    @XmlElement(name = "address")
    private Address address;
}
