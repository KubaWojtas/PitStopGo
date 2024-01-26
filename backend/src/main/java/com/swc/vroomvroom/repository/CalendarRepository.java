package main.java.com.swc.vroomvroom.repository;

import main.java.com.swc.vroomvroom.model.Calendar;
import org.springframework.data.repository.CrudRepository;

public interface CalendarRepository extends CrudRepository<Calendar, Integer> {
}
