package org.soup.businessservice.controller;

import org.soup.common.models.CustomerDto;
import org.soup.businessservice.dto.CustomerCreateRequest;
import org.soup.businessservice.mapper.CustomerCreateMapper;
import org.soup.businessservice.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController extends CrudController<CustomerDto, CustomerCreateRequest> {
    public CustomerController(CrudService<CustomerDto> crudService, CustomerCreateMapper mapper) {
        super(crudService, mapper);
    }
}
