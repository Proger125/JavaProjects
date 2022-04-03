package edu.bsu.web.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Address implements Serializable {

    private Long id;

    private String city;

    private String street;

    private int houseNumber;
}
