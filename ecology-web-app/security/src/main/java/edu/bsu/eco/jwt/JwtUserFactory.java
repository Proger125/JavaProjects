package edu.bsu.eco.jwt;

import edu.bsu.eco.entity.Role;
import edu.bsu.eco.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {}

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getLogin(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRoles())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream().map(role ->
                new SimpleGrantedAuthority(role.getName())
        ).collect(Collectors.toList());
    }
}
