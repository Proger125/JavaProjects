package edu.bsu.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class Order {

    private Long id;

    private BigDecimal totalCost;

    private List<ProductOrder> products;

    private String orderStatus;

}
