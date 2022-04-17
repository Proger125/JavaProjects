package edu.bsu.shop.service.impl;

import edu.bsu.shop.dao.ProductDao;
import edu.bsu.shop.dto.product.ProductInputDto;
import edu.bsu.shop.dto.product.ProductOutputDto;
import edu.bsu.shop.entity.Product;
import edu.bsu.shop.mapper.ProductMapper;
import edu.bsu.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductDao productDao;

    @Override
    public ProductOutputDto save(ProductInputDto dto) {
        Product product = productMapper.toProduct(dto);
        return productMapper.toProductOutputDto(productDao.save(product));
    }

    @Override
    public List<ProductOutputDto> findAll() {
        return productDao.findAll().stream()
                .map(productMapper::toProductOutputDto)
                .collect(Collectors.toList());
    }
}
