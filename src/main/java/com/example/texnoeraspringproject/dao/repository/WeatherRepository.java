package com.example.texnoeraspringproject.dao.repository;

import com.example.texnoeraspringproject.dao.client.WeatherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<WeatherEntity,Long> {
}
