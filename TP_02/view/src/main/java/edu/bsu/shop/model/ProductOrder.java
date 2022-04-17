package edu.bsu.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {

    private Long id;

    private Product product;

    private int quantity;

    public ProductOrder(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
