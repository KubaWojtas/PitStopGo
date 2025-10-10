package com.swc.vroomvroom.repository;

import org.springframework.data.repository.CrudRepository;

import com.swc.vroomvroom.entity.RaceEntity;
import java.util.UUID;

public interface RaceRepository extends CrudRepository<RaceEntity, UUID> {
}
