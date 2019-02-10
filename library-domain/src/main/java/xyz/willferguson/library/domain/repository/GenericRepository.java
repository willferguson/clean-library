package xyz.willferguson.library.domain.repository;

import xyz.willferguson.library.domain.entity.Identifiable;
import xyz.willferguson.library.domain.exceptions.EntityDoesNotExistException;
import xyz.willferguson.library.domain.exceptions.EntityExistsException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GenericRepository<T extends Identifiable> {

    T create(T t) throws EntityExistsException;
    T update(T t) throws EntityDoesNotExistException;
    Optional<T> get(UUID uuid);
    void delete(UUID uuid) throws EntityDoesNotExistException;
    List<T> list();

}
