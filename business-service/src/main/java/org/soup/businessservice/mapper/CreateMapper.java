package org.soup.businessservice.mapper;

import org.mapstruct.*;

public interface CreateMapper<EntityDto, EntityCreateRequest> {
    EntityDto toEntityDto(EntityCreateRequest entityCreateRequest);

    EntityCreateRequest toEntityRequest(EntityDto entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EntityDto partialUpdate(EntityCreateRequest dto, @MappingTarget EntityDto entity);
}
