package edu.bsu.web.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResidentDto implements Serializable {

    private String firstName;

    private String lastName;

    private String city;

    private String street;

    private int houseNumber;
}
