package edu.bsu.shop.service;

import edu.bsu.shop.dto.user.UserDto;
import edu.bsu.shop.dto.user.UserLoginDto;

public interface UserService {
    UserDto login(UserLoginDto dto);
}
