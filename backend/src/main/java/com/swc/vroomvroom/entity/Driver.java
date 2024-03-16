package main.java.com.swc.vroomvroom.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "DRIVER")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String country;
    private String number;
    private int teamId;
    private int winChangeMin;
    private int winChangeMax;

    @OneToMany(mappedBy = "driver")
    private Set<RaceStanding> standings;

    public void addStandings(RaceStanding raceStanding) {
        standings.add(raceStanding);
    }

}
