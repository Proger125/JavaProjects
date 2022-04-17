package edu.bsu.shop.controller;

import edu.bsu.shop.dto.product.ProductInputDto;
import edu.bsu.shop.dto.product.ProductOutputDto;
import edu.bsu.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductOutputDto save(@RequestBody ProductInputDto dto) {
        return productService.save(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductOutputDto> findAll() {
        return productService.findAll();
    }
}
