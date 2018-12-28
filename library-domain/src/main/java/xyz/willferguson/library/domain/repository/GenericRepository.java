package xyz.willferguson.library.domain.repository;

import java.util.List;
import java.util.UUID;

public interface GenericRepository<T> {

    T create(T t);
    T update(T t);
    T get(UUID uuid);
    void delete(UUID uuid);
    List<T> list();

}
