package edu.bsu.shop.model;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String login;

    private String role;
}
