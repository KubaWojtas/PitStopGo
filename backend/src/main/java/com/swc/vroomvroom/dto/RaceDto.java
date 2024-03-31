package main.java.com.swc.vroomvroom.dto;

import lombok.Data;
import main.java.com.swc.vroomvroom.entity.RaceStanding;

import java.time.LocalDate;
import java.util.Set;

@Data
public class RaceDto {

    private int raceId;
    private int calendarId;
    private int trackId;
    private LocalDate dateOfRace;
    private Set<RaceStanding> standings;
}
