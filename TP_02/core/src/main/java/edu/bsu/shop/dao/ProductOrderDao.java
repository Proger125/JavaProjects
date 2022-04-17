package edu.bsu.shop.dao;

import edu.bsu.shop.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderDao extends JpaRepository<ProductOrder, Long> {
}
