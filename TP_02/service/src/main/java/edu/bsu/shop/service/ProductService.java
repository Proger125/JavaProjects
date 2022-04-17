package edu.bsu.shop.service;

import edu.bsu.shop.dto.product.ProductInputDto;
import edu.bsu.shop.dto.product.ProductOutputDto;

import java.util.List;

public interface ProductService {

    ProductOutputDto save(ProductInputDto dto);

    List<ProductOutputDto> findAll();
}
