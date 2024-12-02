package org.soup.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.soup.dataservice.entity.AbstractEntity;
import org.soup.dataservice.mappers.DtoMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.messaging.handler.annotation.Header;

@RequiredArgsConstructor
public class CrudRabbitService<
        Entity extends AbstractEntity,
        EntityDto,
        Repository extends JpaRepository<Entity, Long>,
        Mapper extends DtoMapper<Entity, EntityDto>> {

    private final Repository repository;
    private final Mapper mapper;

    public String handleMessage(EntityDto entityDto, @Header("amqp_receivedRoutingKey") String routingKey) {
        try {
            return switch (routingKey) {
                case "create" -> create(entityDto);
                case "update" -> update(entityDto);
                case "delete" -> delete(entityDto);
                default -> throw new IllegalArgumentException("Unsupported operation: " + routingKey);
            };
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private String create(EntityDto entityDto) {
        Entity entity = mapper.toEntity(entityDto);
        repository.save(entity);
        return "Created";
    }

    private String update(EntityDto entityDto) {
        repository.save(mapper.toEntity(entityDto));
        return "Updated";
    }

    private String delete(EntityDto entityDto) {
        Entity entity = mapper.toEntity(entityDto);
        repository.deleteById(entity.getId());
        return "Successfully deleted";
    }
}
