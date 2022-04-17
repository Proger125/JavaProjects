package edu.bsu.eco.dto.user;

import lombok.Data;

@Data
public class UserLoginInputDto {

    private String login;

    private String password;
}
