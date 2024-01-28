package main.java.com.swc.vroomvroom.repository;

import main.java.com.swc.vroomvroom.entity.Driver;
import main.java.com.swc.vroomvroom.entity.Race;
import org.springframework.data.repository.CrudRepository;

public interface RaceRepository extends CrudRepository<Race, Integer> {
}
