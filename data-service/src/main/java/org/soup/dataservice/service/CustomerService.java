package org.soup.dataservice.service;

import models.CustomerDto;
import org.soup.dataservice.entity.Customer;
import org.soup.dataservice.mappers.CustomerMapper;
import org.soup.dataservice.repository.CustomerRepository;
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
}
