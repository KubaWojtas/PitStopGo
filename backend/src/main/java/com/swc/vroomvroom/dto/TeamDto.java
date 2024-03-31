package main.java.com.swc.vroomvroom.dto;

import lombok.Data;
import main.java.com.swc.vroomvroom.entity.Driver;

import java.util.HashSet;
import java.util.Set;

@Data
public class TeamDto {

    private int teamId;
    private String name;
    private String country;
    private Set<Driver> drivers = new HashSet<>();
}
