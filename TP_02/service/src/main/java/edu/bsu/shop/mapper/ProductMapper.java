package edu.bsu.shop.mapper;

import edu.bsu.shop.dto.product.ProductInputDto;
import edu.bsu.shop.dto.product.ProductOutputDto;
import edu.bsu.shop.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProductMapper {

    Product toProduct(ProductInputDto dto);

    ProductOutputDto toProductOutputDto(Product product);
}
