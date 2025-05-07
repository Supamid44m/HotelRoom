package com.example.HotelRoom.model.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface GenericMapper<T, D> {
    D toDto(T entity);

    List<D> toDtoList(List<T> entity);

    T toEntity(D dto);
    
}
