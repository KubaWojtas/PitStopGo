package main.java.com.swc.vroomvroom.dto;

import lombok.Data;
import main.java.com.swc.vroomvroom.entity.RaceStanding;

import java.time.LocalDate;
import java.util.Set;

@Data
public class DriverDto {

    private int driverId;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String country;
    private String number;
    private int teamId;
    private Set<RaceStanding> standings;
}
