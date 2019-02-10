package xyz.willferguson.library.application.usecase;

import xyz.willferguson.library.application.usecase.dto.PersonDTO;
import xyz.willferguson.library.application.usecase.dto.mapper.DTOMapper;
import xyz.willferguson.library.domain.entity.Person;
import xyz.willferguson.library.domain.exceptions.EntityExistsException;
import xyz.willferguson.library.domain.repository.PersonRepository;

/**
 * Anyone can create borrowers - including anon
 */
public class AddBorrowerUseCase {

    private PersonRepository personRepository;
    private DTOMapper<PersonDTO, Person> mapper;

    public AddBorrowerUseCase(PersonRepository personRepository, DTOMapper<PersonDTO, Person> mapper) {
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    public PersonDTO addBorrower(PersonDTO personDTO) throws EntityExistsException {
        Person person = mapper.fromDTO(personDTO, Person.class);
        return mapper.toDTO(personRepository.create(person), PersonDTO.class);
    }
}
