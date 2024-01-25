package main.java.com.swc.vroomvroom.repository;

import main.java.com.swc.vroomvroom.model.Calender;
import main.java.com.swc.vroomvroom.model.Track;
import org.springframework.data.repository.CrudRepository;

public interface CalenderRepository extends CrudRepository<Calender, Integer> {
}
