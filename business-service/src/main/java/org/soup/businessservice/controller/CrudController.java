package org.soup.businessservice.controller;

import lombok.RequiredArgsConstructor;
import org.soup.businessservice.mapper.CreateMapper;
import org.soup.businessservice.service.CrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public class CrudController<Entity, EntityCreateRequest> {
    private final CrudService<Entity> crudService;
    private final CreateMapper<Entity, EntityCreateRequest> mapper;

    @GetMapping("/")
    public List<Entity> getAll() {
        return crudService.getAll();
    }

    @GetMapping("/{id}")
    public Entity getById(@PathVariable Long id) {
        return crudService.getById(id);
    }

    @PostMapping("/")
    public String save(@RequestBody EntityCreateRequest entityCreateRequest) {
        return crudService.create(mapper.toEntityDto(entityCreateRequest));
    }

    @PutMapping("/")
    public String update(@RequestBody Entity entity) {
        return crudService.update(entity);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return crudService.delete(id);
    }
}
