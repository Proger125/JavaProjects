package edu.bsu.web.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Entity class for resident collection
 * @see java.io.Serializable
 * @author Aleksandr Dzyachenka
 */
@XmlRootElement(name = "residents")
@XmlAccessorType(XmlAccessType.FIELD)
public class Residents implements Serializable{

    /**
     * @value util constant for correct serializing
     */
    @Serial
    private static final long serialVersionUID = -933066477012072293L;

    /**
     * Residents
     */
    @XmlElement(name = "resident")
    private List<Resident> residents = null;

    /**
     * Return all residents
     * @return residents
     */
    public List<Resident> getResidents() {
        return residents;
    }

    /**
     * Set residents
     * @param residents - new residents
     */
    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }
}
