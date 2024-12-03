package org.soup.businessservice.service;


import lombok.RequiredArgsConstructor;
import org.soup.common.models.CustomerDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CustomerService implements CrudService<CustomerDto> {
    private final RabbitTemplate rabbitTemplate;
    private final RestTemplate restTemplate;

    @Value("${data-service.url}")
    private String dataServiceUrl;

    @Override
    public List<CustomerDto> getAll() {
        String url = dataServiceUrl + "/customers/";
        var response = restTemplate.getForObject(url, CustomerDto[].class);
        return List.of(Objects.requireNonNull(response));
    }

    @Override
    public CustomerDto getById(Long id) {
        String url = dataServiceUrl + "/customers/" + id;
        return restTemplate.getForObject(url, CustomerDto.class);
    }

    @Override
    public String create(CustomerDto customer) {
        return (String) rabbitTemplate.convertSendAndReceive("customer.exchange", "create", customer);
    }

    @Override
    public String update(CustomerDto customerDto) {
        CustomerDto customer = new CustomerDto(customerDto.id(), customerDto.name(), customerDto.phone());
        return (String) rabbitTemplate.convertSendAndReceive("customer.exchange", "update", customer);
    }

    @Override
    public String delete(Long id) {
        CustomerDto customer = new CustomerDto(id, null, null);
        return (String) rabbitTemplate.convertSendAndReceive("customer.exchange", "delete", customer);
    }
}
