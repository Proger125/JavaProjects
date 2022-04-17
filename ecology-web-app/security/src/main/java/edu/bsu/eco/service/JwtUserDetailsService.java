package edu.bsu.eco.service;

import edu.bsu.eco.dao.UserDao;
import edu.bsu.eco.entity.User;
import edu.bsu.eco.jwt.JwtUserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Primary
public class JwtUserDetailsService implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDao.findUserByLogin(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User with username " + username + " not found");
        }

        return JwtUserFactory.create(optionalUser.get());
    }
}
