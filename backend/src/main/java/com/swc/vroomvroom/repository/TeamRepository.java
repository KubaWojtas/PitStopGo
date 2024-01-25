package main.java.com.swc.vroomvroom.repository;

import main.java.com.swc.vroomvroom.model.Driver;
import main.java.com.swc.vroomvroom.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Integer> {
}
