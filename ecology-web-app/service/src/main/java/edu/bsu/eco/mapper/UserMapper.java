package edu.bsu.eco.mapper;

import edu.bsu.eco.dto.user.UserLoginOutputDto;
import edu.bsu.eco.dto.user.UserRegisterOutputDto;
import edu.bsu.eco.dto.user.UserRegisterInputDto;
import edu.bsu.eco.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User toUser(UserRegisterInputDto dto);

    UserRegisterOutputDto toUserOutputDto(User user);

    UserLoginOutputDto toUserLoginOutputDto(User user);
}
