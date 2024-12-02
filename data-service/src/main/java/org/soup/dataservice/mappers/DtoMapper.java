package org.soup.dataservice.mappers;

import org.mapstruct.*;

public interface DtoMapper<Entity, Dto> {
    Entity toEntity(Dto dto);

    Dto toDto(Entity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Entity partialUpdate(Dto dto, @MappingTarget Entity entity);
}
