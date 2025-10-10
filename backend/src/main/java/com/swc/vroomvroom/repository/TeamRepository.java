package com.swc.vroomvroom.repository;

import com.swc.vroomvroom.entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeamRepository extends CrudRepository<TeamEntity, UUID> {
}
