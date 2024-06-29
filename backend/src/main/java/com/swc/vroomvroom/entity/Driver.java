package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID driverId;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String country;
    private String number;
    private UUID teamId;
    private int winChangeMin;
    private int winChangeMax;

    @OneToMany(mappedBy = "driver")
    private Set<RaceStanding> standings;

    public void addStandings(RaceStanding raceStanding) {
        standings.add(raceStanding);
    }

}
