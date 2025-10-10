package com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "race")
public class RaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID raceId;
    private UUID calendarId;
    private UUID trackId;
    private LocalDate dateOfRace;

    @OneToMany(mappedBy = "race")
    private Set<RaceStandingEntity> standings;

    public void addRaceStanding(RaceStandingEntity raceStanding) {
        standings.add(raceStanding);
    }

    public Map<UUID, Integer> simulateRace(Set<DriverEntity> drivers) {
        Map<UUID, Integer> standing = new HashMap<>();
        ThreadLocalRandom random = ThreadLocalRandom.current();

        drivers.forEach(driver ->
                standing.put(driver.getDriverId(), random.nextInt(driver.getWinChangeMin(), driver.getWinChangeMax() + 1))
        );

        return standing.entrySet()
                .stream()
                .sorted(Map.Entry.<UUID, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}
