package edu.bsu.shop.dao;

import edu.bsu.shop.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    Optional<User> findFirstByLogin(String login);
}
