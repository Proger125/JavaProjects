package edu.bsu.shop.mapper;

import edu.bsu.shop.dto.order.ChangeStatusOrderDto;
import edu.bsu.shop.dto.order.OrderInputDto;
import edu.bsu.shop.dto.order.OrderOutputDto;
import edu.bsu.shop.entity.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {ProductOrderMapper.class, UserMapper.class})
@Component
public interface OrderMapper {

    Order toOrder(OrderInputDto dto);

    Order toOrder(ChangeStatusOrderDto dto);

    OrderOutputDto toOrderOutputDto(Order order);
}
