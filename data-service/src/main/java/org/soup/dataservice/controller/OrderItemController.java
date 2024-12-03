package org.soup.dataservice.controller;

import org.soup.dataservice.entity.OrderItem;
import org.soup.dataservice.repository.OrderItemRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController extends DetailsController<OrderItem, OrderItemRepository> {
    public OrderItemController(OrderItemRepository repository) {
        super(repository);
    }
}
