package edu.bsu.shop.service.impl;

import edu.bsu.shop.dao.UserDao;
import edu.bsu.shop.dto.user.UserDto;
import edu.bsu.shop.dto.user.UserLoginDto;
import edu.bsu.shop.entity.User;
import edu.bsu.shop.exception.IncorrectLoginOrPasswordException;
import edu.bsu.shop.mapper.UserMapper;
import edu.bsu.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao  userDao;

    private final UserMapper userMapper;

    @Override
    public UserDto login(UserLoginDto dto) {
        User user = userDao.findFirstByLogin(dto.getLogin())
                .orElseThrow(IncorrectLoginOrPasswordException::new);
        String hashedPassword = user.getPassword();
        boolean result = BCrypt.checkpw(dto.getPassword(), hashedPassword);
        if (!result) {
            throw new IncorrectLoginOrPasswordException();
        }
        return userMapper.toUserDto(user);
    }
}
