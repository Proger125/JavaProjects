package edu.bsu.eco.dto.user;

import edu.bsu.eco.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserLoginOutputDto {

    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    private String email;

    private List<Role> roles;

    private String token;
}
