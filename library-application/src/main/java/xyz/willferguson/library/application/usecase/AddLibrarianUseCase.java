package xyz.willferguson.library.application.usecase;

import xyz.willferguson.library.application.usecase.dto.PersonDTO;
import xyz.willferguson.library.application.usecase.dto.mapper.DTOMapper;
import xyz.willferguson.library.domain.entity.Person;
import xyz.willferguson.library.domain.exceptions.EntityExistsException;
import xyz.willferguson.library.domain.exceptions.InvalidOperationException;
import xyz.willferguson.library.domain.repository.PersonRepository;

import java.util.UUID;

/**
 * Only librarians can add librarians
 */
public class AddLibrarianUseCase {

    private PersonRepository personRepository;
    private DTOMapper<PersonDTO, Person> mapper;

    public AddLibrarianUseCase(PersonRepository personRepository, DTOMapper<PersonDTO, Person> mapper) {
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    public PersonDTO addLibrarian(PersonDTO personDTO, UUID currentPersonId) throws EntityExistsException {
        Person currentPerson = personRepository.get(currentPersonId).orElseThrow(EntityExistsException::new);
        if (!currentPerson.isLibrarian()) {
            throw new InvalidOperationException("Not a librarian");
        }
        Person person = mapper.fromDTO(personDTO, Person.class);
        return mapper.toDTO(personRepository.create(person), PersonDTO.class);
    }
}
