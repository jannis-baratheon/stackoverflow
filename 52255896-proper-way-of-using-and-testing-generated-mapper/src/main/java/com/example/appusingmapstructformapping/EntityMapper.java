package com.example.appusingmapstructformapping;

import org.mapstruct.Mapper;

@Mapper
public interface EntityMapper {
    ADto toDto(AnEntity entity);
}
