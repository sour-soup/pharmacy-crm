package org.soup.dataservice.service;

import org.soup.common.models.CustomerDto;
import org.soup.dataservice.entity.Customer;
import org.soup.dataservice.mapper.CustomerMapper;
import org.soup.dataservice.repository.CustomerRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends CrudRabbitService<
        Customer,
        CustomerDto,
        CustomerRepository,
        CustomerMapper> {

    public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @RabbitListener(queues = "customer.queue")
    public String handleMessage(CustomerDto customerDto, String routingKey){
        try {
            return switch (routingKey) {
                case "create" -> create(customerDto);
                case "update" -> update(customerDto);
                case "delete" -> delete(customerDto);
                default -> throw new IllegalArgumentException("Unsupported operation: " + routingKey);
            };
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
