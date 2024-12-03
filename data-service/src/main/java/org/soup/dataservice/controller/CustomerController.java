package org.soup.dataservice.controller;

import org.soup.dataservice.entity.Customer;
import org.soup.dataservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController extends DetailsController<Customer, CustomerRepository> {
    public CustomerController(CustomerRepository repository) {
        super(repository);
    }
}
