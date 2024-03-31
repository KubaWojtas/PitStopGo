package main.java.com.swc.vroomvroom.dto;

import lombok.Data;
import main.java.com.swc.vroomvroom.entity.Race;

import java.util.HashSet;
import java.util.Set;

@Data
public class CalanderDto {

    private int calendarId;
    private String name;
    private Set<Race> races = new HashSet<>();
}
