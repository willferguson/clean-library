package xyz.willferguson.library.data.repository;

import xyz.willferguson.library.domain.entity.Identifiable;
import xyz.willferguson.library.domain.exceptions.EntityDoesNotExistException;
import xyz.willferguson.library.domain.exceptions.EntityExistsException;
import xyz.willferguson.library.domain.repository.GenericRepository;

import java.util.*;

public abstract class InMemoryRepository<T extends Identifiable> implements GenericRepository<T> {

    protected Map<UUID, T> repo = new HashMap<>();


    @Override
    public T create(T t) throws EntityExistsException {
        if (repo.containsKey(t.getId())) {
            throw new EntityExistsException();
        }
        repo.put(t.getId(), t);
        return t;
    }

    @Override
    public T update(T t) throws EntityDoesNotExistException{
        if (!repo.containsKey(t.getId())) {
            throw new EntityDoesNotExistException();
        }
        repo.replace(t.getId(), t);
        return t;
    }

    @Override
    public Optional<T> get(UUID uuid) {
        return Optional.ofNullable(repo.get(uuid));
    }

    @Override
    public void delete(UUID uuid) throws EntityDoesNotExistException {
        Optional.ofNullable(repo.remove(uuid)).orElseThrow(EntityDoesNotExistException::new);
    }

    @Override
    public List<T> list() {
        return new ArrayList<>(repo.values());
    }
}
