package org.soup.businessservice.controller;

import org.soup.common.models.MedicineDto;
import org.soup.businessservice.requests.MedicineCreateRequest;
import org.soup.businessservice.mapper.MedicineCreateMapper;
import org.soup.businessservice.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicines/")
public class MedicineController extends CrudController<MedicineDto, MedicineCreateRequest> {
    public MedicineController(CrudService<MedicineDto> crudService, MedicineCreateMapper mapper) {
        super(crudService, mapper);
    }
}
