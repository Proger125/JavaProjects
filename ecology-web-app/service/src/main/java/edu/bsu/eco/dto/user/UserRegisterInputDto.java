package edu.bsu.eco.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UserRegisterInputDto {

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    @Email
    private String email;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Pattern(regexp = "^ROLE_USER|ROLE_AUTHOR$")
    private String role;
}
