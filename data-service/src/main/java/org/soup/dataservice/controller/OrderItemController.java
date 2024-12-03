package org.soup.dataservice.controller;

import org.soup.common.models.OrderItemDto;
import org.soup.dataservice.entity.OrderItem;
import org.soup.dataservice.mapper.OrderItemMapper;
import org.soup.dataservice.repository.OrderItemRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController extends DetailsController<
        OrderItem,
        OrderItemDto,
        OrderItemRepository,
        OrderItemMapper> {
    public OrderItemController(OrderItemRepository repository, OrderItemMapper mapper) {
        super(repository, mapper);
    }
}
