package org.soup.businessservice.controller;

import org.soup.common.models.OrderDto;
import org.soup.businessservice.requests.OrderCreateRequest;
import org.soup.businessservice.mapper.OrderCreateMapper;
import org.soup.businessservice.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders/")
public class OrderController extends CrudController<OrderDto, OrderCreateRequest> {
    public OrderController(CrudService<OrderDto> crudService, OrderCreateMapper mapper) {
        super(crudService, mapper);
    }
}
