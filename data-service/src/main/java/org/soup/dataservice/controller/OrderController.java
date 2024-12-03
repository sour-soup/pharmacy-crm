package org.soup.dataservice.controller;

import org.soup.dataservice.entity.Order;
import org.soup.dataservice.repository.OrderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders/")
public class OrderController extends DetailsController<Order, OrderRepository> {
    public OrderController(OrderRepository repository) {
        super(repository);
    }
}
