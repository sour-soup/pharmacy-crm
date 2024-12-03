package org.soup.dataservice.controller;

import org.soup.dataservice.entity.Medicine;
import org.soup.dataservice.repository.MedicineRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController extends DetailsController<Medicine, MedicineRepository> {
    public MedicineController(MedicineRepository repository) {
        super(repository);
    }
}
