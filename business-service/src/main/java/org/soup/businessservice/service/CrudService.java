package org.soup.businessservice.service;

import java.util.List;

public interface CrudService<Entity> {

    List<Entity> getAll();

    Entity getById(Long id);

    String create(Entity entity);

    String update(Entity entity);

    String delete(Long id);
}
