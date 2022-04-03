package edu.bsu.web.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Resident implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private Address address;
}
