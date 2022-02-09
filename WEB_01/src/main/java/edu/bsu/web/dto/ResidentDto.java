package edu.bsu.web.dto;

import lombok.Data;

@Data
public class ResidentDto {

    private String firstName;

    private String lastName;

    private String city;

    private String street;

    private int houseNumber;
}
