package edu.bsu.eco.service;

import edu.bsu.eco.dto.user.UserLoginInputDto;
import edu.bsu.eco.dto.user.UserLoginOutputDto;
import edu.bsu.eco.dto.user.UserRegisterOutputDto;
import edu.bsu.eco.dto.user.UserRegisterInputDto;

public interface UserService {

    UserRegisterOutputDto register(UserRegisterInputDto dto);

    UserLoginOutputDto login(UserLoginInputDto dto);
}
