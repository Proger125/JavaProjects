package edu.bsu.shop.mapper;

import edu.bsu.shop.dto.user.UserDto;
import edu.bsu.shop.dto.user.UserInputDto;
import edu.bsu.shop.dto.user.UserLoginDto;
import edu.bsu.shop.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    User toUser(UserLoginDto dto);

    User toUser(UserInputDto dto);

    UserDto toUserDto(User user);
}
