package org.soup.dataservice.controller;

import org.soup.common.models.PharmacistDto;
import org.soup.dataservice.entity.Pharmacist;
import org.soup.dataservice.mapper.PharmacistMapper;
import org.soup.dataservice.repository.PharmacistRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pharmacists")
public class PharmacistController extends DetailsController<
        Pharmacist,
        PharmacistDto,
        PharmacistRepository,
        PharmacistMapper> {
    public PharmacistController(PharmacistRepository repository, PharmacistMapper mapper) {
        super(repository, mapper);
    }
}
