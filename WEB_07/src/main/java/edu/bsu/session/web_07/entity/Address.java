package edu.bsu.session.web_07.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private Long id;

    private String city;

    private String street;

    private int houseNumber;
}
