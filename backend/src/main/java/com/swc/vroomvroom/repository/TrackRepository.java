package main.java.com.swc.vroomvroom.repository;

import main.java.com.swc.vroomvroom.model.Track;
import org.springframework.data.repository.CrudRepository;

public interface TrackRepository extends CrudRepository<Track, Integer> {
}
