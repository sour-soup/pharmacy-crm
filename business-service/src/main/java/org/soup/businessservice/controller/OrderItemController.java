package org.soup.businessservice.controller;

import org.soup.common.models.OrderItemDto;
import org.soup.businessservice.requests.OrderItemCreateRequest;
import org.soup.businessservice.mapper.OrderItemCreateMapper;
import org.soup.businessservice.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-items/")
public class OrderItemController extends CrudController<OrderItemDto, OrderItemCreateRequest> {
    public OrderItemController(CrudService<OrderItemDto> crudService, OrderItemCreateMapper mapper) {
        super(crudService, mapper);
    }
}
