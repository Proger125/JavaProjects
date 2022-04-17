package edu.bsu.eco.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class JwtUser extends User {

    private Long id;

    private String login;

    private String password;

    private Collection<GrantedAuthority> authorities;

    public JwtUser(String login, String password, Collection<GrantedAuthority> authorities) {
        super(login, password, authorities);
        this.login = login;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
