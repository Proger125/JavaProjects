package edu.bsu.session.web_07.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Resident {

    private Long id;

    private String firstName;

    private String lastName;

    private Address address;
}
