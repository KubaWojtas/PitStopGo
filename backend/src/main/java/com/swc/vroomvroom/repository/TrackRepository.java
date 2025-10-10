package com.swc.vroomvroom.repository;

import com.swc.vroomvroom.entity.TrackEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TrackRepository extends CrudRepository<TrackEntity, UUID> {
}
