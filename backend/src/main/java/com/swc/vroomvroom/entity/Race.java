package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Entity
@Table(name = "RACE")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int raceId;
    private int calendarId;
    private int trackId;
    private LocalDate dateOfRace;

    @OneToMany(mappedBy = "race")
    private Set<RaceStanding> standings;

    public void addRaceStanding(RaceStanding raceStanding) {
        standings.add(raceStanding);
    }

    public Map<Integer, Integer> simulateRace(List<Driver> drivers) {
        Map<Integer, Integer> standing = new HashMap<>();
        ThreadLocalRandom random = ThreadLocalRandom.current();

        drivers.forEach(driver ->
                standing.put(driver.getDriverId(), random.nextInt(driver.getWinChangeMin(), driver.getWinChangeMax() + 1))
        );

        return standing.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
