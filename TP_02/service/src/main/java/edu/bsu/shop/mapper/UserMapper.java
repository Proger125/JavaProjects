package edu.bsu.shop.mapper;

import edu.bsu.shop.dto.UserDto;
import edu.bsu.shop.dto.UserLoginDto;
import edu.bsu.shop.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    User toUser(UserLoginDto dto);

    UserDto toUserDto(User user);
}
