package org.soup.businessservice.service;

import lombok.RequiredArgsConstructor;
import org.soup.common.models.OrderDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class OrderService implements CrudService<OrderDto> {
    private final RabbitTemplate rabbitTemplate;
    private final RestTemplate restTemplate;

    @Value("${data-service.url}")
    private String dataServiceUrl;

    @Override
    public List<OrderDto> getAll() {
        String url = dataServiceUrl + "/orders/";
        var response = restTemplate.getForObject(url, OrderDto[].class);
        return List.of(Objects.requireNonNull(response));
    }

    @Override
    public OrderDto getById(Long id) {
        String url = dataServiceUrl + "/orders/" + id;
        return restTemplate.getForObject(url, OrderDto.class);
    }

    @Override
    public String create(OrderDto order) {
        return (String) rabbitTemplate.convertSendAndReceive("order.exchange", "create", order);
    }

    @Override
    public String update(OrderDto orderDto) {
        return (String) rabbitTemplate.convertSendAndReceive("order.exchange", "update", orderDto);
    }

    @Override
    public String delete(Long id) {
        OrderDto order = new OrderDto(id, null, null, null);
        return (String) rabbitTemplate.convertSendAndReceive("order.exchange", "delete", order);
    }
}

