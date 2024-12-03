package org.soup.dataservice.controller;

import org.soup.common.models.CustomerDto;
import org.soup.dataservice.entity.Customer;
import org.soup.dataservice.mapper.CustomerMapper;
import org.soup.dataservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController extends DetailsController<
        Customer,
        CustomerDto,
        CustomerRepository,
        CustomerMapper> {
    public CustomerController(CustomerRepository repository, CustomerMapper mapper) {
        super(repository, mapper);
    }
}
