package com.swc.vroomvroom.repository;

import com.swc.vroomvroom.entity.DriverEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DriverRepository extends CrudRepository<DriverEntity, UUID> {
}
