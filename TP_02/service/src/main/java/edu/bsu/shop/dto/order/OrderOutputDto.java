package edu.bsu.shop.dto.order;

import edu.bsu.shop.entity.OrderStatus;
import edu.bsu.shop.entity.ProductOrder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderOutputDto {

    private Long id;

    private BigDecimal totalCost;

    private List<ProductOrder> products;

    private OrderStatus orderStatus;
}
