package edu.bsu.eco.controller;

import edu.bsu.eco.dto.user.UserLoginInputDto;
import edu.bsu.eco.dto.user.UserLoginOutputDto;
import edu.bsu.eco.dto.user.UserRegisterInputDto;
import edu.bsu.eco.dto.user.UserRegisterOutputDto;
import edu.bsu.eco.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/auth/registration")
    public UserRegisterOutputDto register(@RequestBody @Valid UserRegisterInputDto dto) {
        return userService.register(dto);
    }

    @PostMapping("/auth/login")
    public UserLoginOutputDto login(@RequestBody @Valid UserLoginInputDto dto) {
        return userService.login(dto);
    }
}
