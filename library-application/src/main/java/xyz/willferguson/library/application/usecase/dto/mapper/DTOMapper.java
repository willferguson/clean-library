package xyz.willferguson.library.application.usecase.dto.mapper;

public interface DTOMapper<DTO, ENTITY> {

    DTO toDTO(ENTITY entity, Class<DTO> dtoClass);

    ENTITY fromDTO(DTO dto, Class<ENTITY> entityClass);

}
