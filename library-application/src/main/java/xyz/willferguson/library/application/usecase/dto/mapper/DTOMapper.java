package xyz.willferguson.library.application.usecase.dto.mapper;

public interface DTOMapper<DTO, ENTITY> {

    DTO toDTO(ENTITY entity);

    ENTITY fromDTO(DTO dto);

}
