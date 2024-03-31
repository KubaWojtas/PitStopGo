package main.java.com.swc.vroomvroom.dto;

import lombok.Data;
import main.java.com.swc.vroomvroom.entity.Race;

import java.util.HashSet;
import java.util.Set;

@Data
public class TrackDto {

    private int trackId;
    private String name;
    private String location;
    private String country;
    private double distance;
    private float lapRecord;
    private Set<Race> races = new HashSet<>();
}
