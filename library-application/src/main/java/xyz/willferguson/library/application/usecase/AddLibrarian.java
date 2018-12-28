package xyz.willferguson.library.application.usecase;

import xyz.willferguson.library.application.usecase.dto.PersonDTO;
import xyz.willferguson.library.application.usecase.dto.mapper.DTOMapper;
import xyz.willferguson.library.domain.entity.Person;
import xyz.willferguson.library.domain.exceptions.InvaidOperationException;
import xyz.willferguson.library.domain.repository.GenericRepository;
import xyz.willferguson.library.domain.repository.PersonRepository;

import java.util.UUID;

/**
 * Only librarians can add librarians
 */
public class AddLibrarian {

    private PersonRepository personRepository;
    private DTOMapper<PersonDTO, Person> mapper;

    public AddLibrarian(PersonRepository personRepository, DTOMapper<PersonDTO, Person> mapper) {
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    public PersonDTO addLibrarian(PersonDTO personDTO, UUID currentPersonId) {
        Person currentPerson = personRepository.get(currentPersonId);
        if (!currentPerson.isLibrarian()) {
            throw new InvaidOperationException("Not a librarian");
        }
        Person person = mapper.fromDTO(personDTO);
        return mapper.toDTO(personRepository.create(person));
    }
}
