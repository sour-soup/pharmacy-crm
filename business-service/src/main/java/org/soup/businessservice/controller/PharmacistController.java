package org.soup.businessservice.controller;

import org.soup.common.models.PharmacistDto;
import org.soup.businessservice.requests.PharmacistCreateRequest;
import org.soup.businessservice.mapper.PharmacistCreateMapper;
import org.soup.businessservice.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pharmacists/")
public class PharmacistController extends CrudController<PharmacistDto, PharmacistCreateRequest> {
    public PharmacistController(CrudService<PharmacistDto> crudService, PharmacistCreateMapper mapper) {
        super(crudService, mapper);
    }
}
