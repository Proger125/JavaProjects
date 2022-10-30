package edu.bsu.session.web_07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentDto {

    public static final String FIRST_NAME = "first-name";
    public static final String LAST_NAME = "last-name";
    public static final String CITY = "city";
    public static final String STREET = "street";
    public static final String HOUSE_NUMBER = "house-number";

    private String firstName;

    private String lastName;

    private String city;

    private String street;

    private int houseNumber;

    public ResidentDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
