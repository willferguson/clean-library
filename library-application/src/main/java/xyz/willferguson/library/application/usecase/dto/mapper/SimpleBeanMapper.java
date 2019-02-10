package xyz.willferguson.library.application.usecase.dto.mapper;

import org.modelmapper.ModelMapper;


public class SimpleBeanMapper<DTO, ENTITY> implements DTOMapper<DTO, ENTITY> {

    private static ModelMapper modelMapper = new ModelMapper();

    @Override
    public DTO toDTO(ENTITY entity, Class<DTO> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public ENTITY fromDTO(DTO dto, Class<ENTITY> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}
