package org.soup.dataservice.controller;

import lombok.RequiredArgsConstructor;
import org.soup.dataservice.entity.AbstractEntity;
import org.soup.dataservice.mapper.DtoMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class DetailsController<
        Entity extends AbstractEntity,
        EntityDto,
        Repository extends JpaRepository<Entity, Long>,
        Mapper extends DtoMapper<Entity, EntityDto>> {

    private final Repository repository;
    private final Mapper mapper;

    @GetMapping("/")
    public List<EntityDto> getAllEntities() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public EntityDto getEntity(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found: " + id)));
    }
}
