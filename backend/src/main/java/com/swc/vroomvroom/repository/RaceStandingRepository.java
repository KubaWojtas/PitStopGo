package main.java.com.swc.vroomvroom.repository;

import main.java.com.swc.vroomvroom.entity.RaceStanding;
import main.java.com.swc.vroomvroom.entity.Track;
import org.springframework.data.repository.CrudRepository;

public interface RaceStandingRepository extends CrudRepository<RaceStanding, Integer> {
}
