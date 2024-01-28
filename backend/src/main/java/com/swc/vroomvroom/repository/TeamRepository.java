package main.java.com.swc.vroomvroom.repository;

import main.java.com.swc.vroomvroom.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Integer> {
}
