package com.swc.vroomvroom.repository;

import org.springframework.data.repository.CrudRepository;

import com.swc.vroomvroom.entity.RaceStandingEntity;
import java.util.UUID;

public interface RaceStandingRepository extends CrudRepository<RaceStandingEntity, UUID> {
}
