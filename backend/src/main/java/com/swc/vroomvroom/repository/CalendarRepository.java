package com.swc.vroomvroom.repository;

import com.swc.vroomvroom.entity.CalendarEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CalendarRepository extends CrudRepository<CalendarEntity, UUID> {
}
