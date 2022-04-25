package edu.bsu.shop.dto.order;

import edu.bsu.shop.dto.user.UserDto;
import edu.bsu.shop.entity.ProductOrder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ChangeStatusOrderDto {

    private Long id;

    private BigDecimal totalCost;

    private List<ProductOrder> products;

    private String orderStatus;

    private UserDto user;
}
