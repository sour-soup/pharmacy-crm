package org.soup.dataservice.service;

import org.soup.common.models.OrderItemDto;
import org.soup.dataservice.entity.OrderItem;
import org.soup.dataservice.mapper.OrderItemMapper;
import org.soup.dataservice.repository.OrderItemRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService extends CrudRabbitService<
        OrderItem,
        OrderItemDto,
        OrderItemRepository,
        OrderItemMapper> {

    public OrderItemService(OrderItemRepository repository, OrderItemMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @RabbitListener(queues = "orderitem.queue")
    public String handleMessage(OrderItemDto orderItemDto, String routingKey) {
        return "";
    }
}
