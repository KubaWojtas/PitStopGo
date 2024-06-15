package main.java.com.swc.vroomvroom.repository;

import main.java.com.swc.vroomvroom.entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeamRepository extends CrudRepository<Team, UUID> {
}
