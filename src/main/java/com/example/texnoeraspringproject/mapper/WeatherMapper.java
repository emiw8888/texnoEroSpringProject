package com.example.texnoeraspringproject.mapper;


import com.example.texnoeraspringproject.dao.client.WeatherEntity;
import com.example.texnoeraspringproject.model.client.WeatherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class WeatherMapper {
    public static WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    @Mapping(target = "created_at",ignore = true)
    public abstract WeatherEntity mapToEntity(WeatherDto teacher);

    public abstract WeatherDto mapToDto(WeatherEntity teacher);
}
