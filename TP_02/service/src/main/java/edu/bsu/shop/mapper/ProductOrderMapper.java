package edu.bsu.shop.mapper;

import edu.bsu.shop.dto.product.ProductInputDto;
import edu.bsu.shop.entity.ProductOrder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProductOrderMapper {

    ProductOrder toProductOrder(ProductInputDto dto);
}
