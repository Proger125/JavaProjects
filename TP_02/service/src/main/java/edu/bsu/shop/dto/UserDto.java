package edu.bsu.shop.dto;

import edu.bsu.shop.entity.Role;
import lombok.Data;

@Data
public class UserDto {

    private String login;

    private Role role;
}
