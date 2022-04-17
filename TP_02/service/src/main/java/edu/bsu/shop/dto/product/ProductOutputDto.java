package edu.bsu.shop.dto.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductOutputDto {

    private Long id;

    private String name;

    private String description;

    private BigDecimal cost;
}
