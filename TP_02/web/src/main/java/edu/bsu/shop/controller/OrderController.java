package edu.bsu.shop.controller;

import edu.bsu.shop.dto.order.ChangeStatusOrderDto;
import edu.bsu.shop.dto.order.OrderInputDto;
import edu.bsu.shop.dto.order.OrderOutputDto;
import edu.bsu.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderOutputDto save(@RequestBody OrderInputDto dto) {
        return orderService.save(dto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderOutputDto findById(@PathVariable long id) {
        return orderService.findById(id);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderOutputDto> findByUser(@PathVariable Long id) {
        return orderService.findByUserId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderOutputDto> findAll() {
        return orderService.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderOutputDto changeOrderStatus(@RequestBody ChangeStatusOrderDto dto) {
        return orderService.changeOrderStatus(dto);
    }
}
