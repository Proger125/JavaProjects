package edu.bsu.shop.dto.productorder;

import edu.bsu.shop.entity.Product;
import lombok.Data;

@Data
public class ProductOrderInputDto {

    private Product product;

    private int quantity;
}
