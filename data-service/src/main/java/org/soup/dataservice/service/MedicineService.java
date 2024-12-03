package org.soup.dataservice.service;

import org.soup.common.models.MedicineDto;
import org.soup.dataservice.entity.Medicine;
import org.soup.dataservice.mapper.MedicineMapper;
import org.soup.dataservice.repository.MedicineRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MedicineService extends CrudRabbitService<
        Medicine,
        MedicineDto,
        MedicineRepository,
        MedicineMapper> {

    public MedicineService(MedicineRepository repository, MedicineMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @RabbitListener(queues = "medicine.queue")
    public String handleMessage(MedicineDto medicineDto, String routingKey) {
        try {
            return switch (routingKey) {
                case "create" -> create(medicineDto);
                case "update" -> update(medicineDto);
                case "delete" -> delete(medicineDto);
                default -> throw new IllegalArgumentException("Unsupported operation: " + routingKey);
            };
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
