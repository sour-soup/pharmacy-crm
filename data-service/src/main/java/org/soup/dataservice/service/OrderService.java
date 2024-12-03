package org.soup.dataservice.service;

import org.soup.common.models.OrderDto;
import org.soup.dataservice.entity.Order;
import org.soup.dataservice.mapper.OrderMapper;
import org.soup.dataservice.repository.OrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends CrudRabbitService<
        Order,
        OrderDto,
        OrderRepository,
        OrderMapper> {

    public OrderService(OrderRepository repository, OrderMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @RabbitListener(queues = "order.queue")
    public String handleMessage(OrderDto orderDto, String routingKey) {
        try {
            return switch (routingKey) {
                case "create" -> create(orderDto);
                case "update" -> update(orderDto);
                case "delete" -> delete(orderDto);
                default -> throw new IllegalArgumentException("Unsupported operation: " + routingKey);
            };
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
