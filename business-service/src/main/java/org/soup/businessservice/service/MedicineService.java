package org.soup.businessservice.service;

import lombok.RequiredArgsConstructor;
import org.soup.common.models.MedicineDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class MedicineService implements CrudService<MedicineDto> {
    private final RabbitTemplate rabbitTemplate;
    private final RestTemplate restTemplate;

    @Value("${data-service.url}")
    private String dataServiceUrl;

    @Override
    public List<MedicineDto> getAll() {
        String url = dataServiceUrl + "/medicines/";
        var response = restTemplate.getForObject(url, MedicineDto[].class);
        return List.of(Objects.requireNonNull(response));
    }

    @Override
    public MedicineDto getById(Long id) {
        String url = dataServiceUrl + "/medicines/" + id;
        return restTemplate.getForObject(url, MedicineDto.class);
    }

    @Override
    public String create(MedicineDto medicine) {
        return (String) rabbitTemplate.convertSendAndReceive("medicine.exchange", "create", medicine);
    }

    @Override
    public String update(MedicineDto medicineDto) {
        return (String) rabbitTemplate.convertSendAndReceive("medicine.exchange", "update", medicineDto);
    }

    @Override
    public String delete(Long id) {
        MedicineDto medicine = new MedicineDto(id, null, null);
        return (String) rabbitTemplate.convertSendAndReceive("medicine.exchange", "delete", medicine);
    }
}

