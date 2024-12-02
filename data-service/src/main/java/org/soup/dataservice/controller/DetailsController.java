package org.soup.dataservice.controller;

import lombok.RequiredArgsConstructor;
import org.soup.dataservice.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
public class DetailsController<Entity extends AbstractEntity, Repository extends JpaRepository<Entity, Long>> {
    private final Repository repository;

    @GetMapping("/")
    public List<Entity> getAllEntities() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Entity getEntity(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}
