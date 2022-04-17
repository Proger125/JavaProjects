package edu.bsu.shop.dto.order;

import edu.bsu.shop.dto.productorder.ProductOrderInputDto;
import edu.bsu.shop.entity.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderInputDto {

    private BigDecimal totalCost;

    private List<ProductOrderInputDto> products;

    private OrderStatus orderStatus;
}
