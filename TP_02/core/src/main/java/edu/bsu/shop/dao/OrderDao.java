package edu.bsu.shop.dao;

import edu.bsu.shop.entity.Order;
import edu.bsu.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
    List<Order> findOrdersByUser(User user);
}
