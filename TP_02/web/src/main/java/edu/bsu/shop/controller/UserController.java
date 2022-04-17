package edu.bsu.shop.controller;

import edu.bsu.shop.dto.user.UserDto;
import edu.bsu.shop.dto.user.UserLoginDto;
import edu.bsu.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public UserDto login(@RequestBody UserLoginDto dto) {
        return userService.login(dto);
    }
}
