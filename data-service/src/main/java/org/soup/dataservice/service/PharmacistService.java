package org.soup.dataservice.service;

import org.soup.common.models.PharmacistDto;
import org.soup.dataservice.entity.Pharmacist;
import org.soup.dataservice.mapper.PharmacistMapper;
import org.soup.dataservice.repository.PharmacistRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PharmacistService extends CrudRabbitService<
        Pharmacist,
        PharmacistDto,
        PharmacistRepository,
        PharmacistMapper> {
    public PharmacistService(PharmacistRepository repository, PharmacistMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @RabbitListener(queues = "pharmacist.queue")
    public String handleMessage(PharmacistDto pharmacistDto, String routingKey) {
        try {
            return switch (routingKey) {
                case "create" -> create(pharmacistDto);
                case "update" -> update(pharmacistDto);
                case "delete" -> delete(pharmacistDto);
                default -> throw new IllegalArgumentException("Unsupported operation: " + routingKey);
            };
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
