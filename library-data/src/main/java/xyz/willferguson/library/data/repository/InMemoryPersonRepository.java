package xyz.willferguson.library.data.repository;

import xyz.willferguson.library.domain.entity.Person;
import xyz.willferguson.library.domain.repository.PersonRepository;

public class InMemoryPersonRepository extends InMemoryRepository<Person> implements PersonRepository {
}
