package edu.bsu.shop.dto.user;

import edu.bsu.shop.entity.Role;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String login;

    private Role role;
}
