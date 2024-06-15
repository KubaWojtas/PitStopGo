package main.java.com.swc.vroomvroom.repository;

import main.java.com.swc.vroomvroom.entity.Track;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TrackRepository extends CrudRepository<Track, UUID> {
}
