package edu.bsu.shop.service.impl;

import edu.bsu.shop.dao.OrderDao;
import edu.bsu.shop.dao.ProductOrderDao;
import edu.bsu.shop.dto.order.OrderInputDto;
import edu.bsu.shop.dto.order.OrderOutputDto;
import edu.bsu.shop.entity.Order;
import edu.bsu.shop.exception.ResourceNotFoundException;
import edu.bsu.shop.mapper.OrderMapper;
import edu.bsu.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    private final ProductOrderDao productOrderDao;

    private final OrderMapper orderMapper;

    @Override
    public OrderOutputDto save(OrderInputDto dto) {
        Order order = orderMapper.toOrder(dto);
        productOrderDao.saveAll(order.getProducts());
        return orderMapper.toOrderOutputDto(orderDao.save(order));
    }

    @Override
    public OrderOutputDto findById(long id) {
        return orderMapper.toOrderOutputDto(orderDao.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public List<OrderOutputDto> findAll() {
        return orderDao.findAll().stream()
                .map(orderMapper::toOrderOutputDto)
                .collect(Collectors.toList());
    }
}
