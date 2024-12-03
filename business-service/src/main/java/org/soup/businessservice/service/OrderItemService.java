package org.soup.businessservice.service;

import lombok.RequiredArgsConstructor;
import org.soup.common.models.OrderItemDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class OrderItemService implements CrudService<OrderItemDto> {
    private final RabbitTemplate rabbitTemplate;
    private final RestTemplate restTemplate;

    @Value("${data-service.url}")
    private String dataServiceUrl;

    @Override
    public List<OrderItemDto> getAll() {
        String url = dataServiceUrl + "/order-items/";
        var response = restTemplate.getForObject(url, OrderItemDto[].class);
        return List.of(Objects.requireNonNull(response));
    }

    @Override
    public OrderItemDto getById(Long id) {
        String url = dataServiceUrl + "/order-items/" + id;
        return restTemplate.getForObject(url, OrderItemDto.class);
    }

    @Override
    public String create(OrderItemDto orderItem) {
        return (String) rabbitTemplate.convertSendAndReceive("order-item.exchange", "create", orderItem);
    }

    @Override
    public String update(OrderItemDto orderItemDto) {
        return (String) rabbitTemplate.convertSendAndReceive("order-item.exchange", "update", orderItemDto);
    }

    @Override
    public String delete(Long id) {
        OrderItemDto orderItem = new OrderItemDto(id, null, null, null, null);
        return (String) rabbitTemplate.convertSendAndReceive("order-item.exchange", "delete", orderItem);
    }
}

