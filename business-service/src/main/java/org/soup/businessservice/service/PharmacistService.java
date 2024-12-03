package org.soup.businessservice.service;

import lombok.RequiredArgsConstructor;
import org.soup.common.models.PharmacistDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class PharmacistService implements CrudService<PharmacistDto> {
    private final RabbitTemplate rabbitTemplate;
    private final RestTemplate restTemplate;

    @Value("${data-service.url}")
    private String dataServiceUrl;

    @Override
    public List<PharmacistDto> getAll() {
        String url = dataServiceUrl + "/pharmacists/";
        var response = restTemplate.getForObject(url, PharmacistDto[].class);
        return List.of(Objects.requireNonNull(response));
    }

    @Override
    public PharmacistDto getById(Long id) {
        String url = dataServiceUrl + "/pharmacists/" + id;
        return restTemplate.getForObject(url, PharmacistDto.class);
    }

    @Override
    public String create(PharmacistDto pharmacist) {
        return (String) rabbitTemplate.convertSendAndReceive("pharmacist.exchange", "create", pharmacist);
    }

    @Override
    public String update(PharmacistDto pharmacistDto) {
        return (String) rabbitTemplate.convertSendAndReceive("pharmacist.exchange", "update", pharmacistDto);
    }

    @Override
    public String delete(Long id) {
        PharmacistDto pharmacist = new PharmacistDto(id, null, null);
        return (String) rabbitTemplate.convertSendAndReceive("pharmacist.exchange", "delete", pharmacist);
    }
}

