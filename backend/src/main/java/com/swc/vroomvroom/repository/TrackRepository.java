package com.swc.vroomvroom.repository;

import com.swc.vroomvroom.entity.Track;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TrackRepository extends CrudRepository<Track, UUID> {
}
