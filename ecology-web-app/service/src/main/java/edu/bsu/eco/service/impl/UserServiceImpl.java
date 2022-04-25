package edu.bsu.eco.service.impl;

import edu.bsu.eco.dao.RoleDao;
import edu.bsu.eco.dao.UserDao;
import edu.bsu.eco.dto.user.UserLoginInputDto;
import edu.bsu.eco.dto.user.UserLoginOutputDto;
import edu.bsu.eco.dto.user.UserRegisterOutputDto;
import edu.bsu.eco.dto.user.UserRegisterInputDto;
import edu.bsu.eco.entity.Role;
import edu.bsu.eco.entity.User;
import edu.bsu.eco.exception.IncorrectLoginOrPasswordException;
import edu.bsu.eco.mapper.UserMapper;
import edu.bsu.eco.service.UserService;
import edu.bsu.eco.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String USER_ROLE = "ROLE_USER";

    private final UserDao userDao;

    private final RoleDao roleDao;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public UserRegisterOutputDto register(UserRegisterInputDto dto) {
        User user = userMapper.toUser(dto);
        Role role = roleDao.findByName(USER_ROLE);
        List<Role> roles = List.of(role);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return userMapper.toUserOutputDto(userDao.save(user));
    }

    @Override
    public UserLoginOutputDto login(UserLoginInputDto dto) {
        String login = dto.getLogin();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, dto.getPassword()));
        User user = userDao.findUserByLogin(login)
                .orElseThrow(IncorrectLoginOrPasswordException::new);
        String token = jwtTokenProvider.createToken(user);
        UserLoginOutputDto userLoginOutputDto = userMapper.toUserLoginOutputDto(user);
        userLoginOutputDto.setToken(token);
        return userLoginOutputDto;
    }

}
