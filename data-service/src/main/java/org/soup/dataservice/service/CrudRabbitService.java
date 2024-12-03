package org.soup.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.soup.dataservice.entity.AbstractEntity;
import org.soup.dataservice.mapper.DtoMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.messaging.handler.annotation.Header;

@RequiredArgsConstructor
public abstract class CrudRabbitService<
        Entity extends AbstractEntity,
        EntityDto,
        Repository extends JpaRepository<Entity, Long>,
        Mapper extends DtoMapper<Entity, EntityDto>> {

    private final Repository repository;
    private final Mapper mapper;

    public abstract String handleMessage(EntityDto entityDto, @Header("amqp_receivedRoutingKey") String routingKey);

    protected String create(EntityDto entityDto) {
        Entity entity = mapper.toEntity(entityDto);
        repository.save(entity);
        return "Created";
    };

    protected String update(EntityDto entityDto) {
        repository.save(mapper.toEntity(entityDto));
        return "Updated";
    }

    protected String delete(EntityDto entityDto) {
        Entity entity = mapper.toEntity(entityDto);
        repository.deleteById(entity.getId());
        return "Deleted";
    }
}
