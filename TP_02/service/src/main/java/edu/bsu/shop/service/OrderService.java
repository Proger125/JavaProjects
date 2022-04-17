package edu.bsu.shop.service;

import edu.bsu.shop.dto.order.OrderInputDto;
import edu.bsu.shop.dto.order.OrderOutputDto;

import java.util.List;

public interface OrderService {

    OrderOutputDto save(OrderInputDto dto);

    OrderOutputDto findById(long id);

    List<OrderOutputDto> findAll();
}
