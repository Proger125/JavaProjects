package edu.bsu.shop.dto.order;

import edu.bsu.shop.dto.user.UserDto;
import edu.bsu.shop.entity.OrderStatus;
import edu.bsu.shop.entity.ProductOrder;
import edu.bsu.shop.entity.User;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderOutputDto {

    private Long id;

    private BigDecimal totalCost;

    private List<ProductOrder> products;

    private OrderStatus orderStatus;

    private UserDto user;
}
