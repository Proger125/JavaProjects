package edu.bsu.shop.service;

import edu.bsu.shop.dto.UserDto;
import edu.bsu.shop.dto.UserLoginDto;

public interface UserService {
    public UserDto login(UserLoginDto dto);
}
