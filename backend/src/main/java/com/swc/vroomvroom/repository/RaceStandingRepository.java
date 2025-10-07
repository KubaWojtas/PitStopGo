package com.swc.vroomvroom.repository;

import org.springframework.data.repository.CrudRepository;

import com.swc.vroomvroom.entity.RaceStanding;
import java.util.UUID;

public interface RaceStandingRepository extends CrudRepository<RaceStanding, UUID> {
}
