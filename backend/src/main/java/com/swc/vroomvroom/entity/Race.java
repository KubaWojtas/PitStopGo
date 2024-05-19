package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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

    private Race(Builder builder) {
        raceId = builder.raceId;
        calendarId = builder.calendarId;
        trackId = builder.trackId;
        dateOfRace = builder.dateOfRace;
        standings = builder.standings;
    }

    public int getRaceId() {
        return raceId;
    }

    public int getCalendarId() {
        return calendarId;
    }

    public int getTrackId() {
        return trackId;
    }

    public LocalDate getDateOfRace() {
        return dateOfRace;
    }

    public Set<RaceStanding> getStandings() {
        return standings;
    }

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


    public static final class Builder {
        private int raceId;
        private int calendarId;
        private int trackId;
        private LocalDate dateOfRace;
        private Set<RaceStanding> standings;

        public Builder withRaceId(int raceId) {
            this.raceId = raceId;
            return this;
        }

        public Builder withCalendarId(int calendarId) {
            this.calendarId = calendarId;
            return this;
        }

        public Builder withTrackId(int trackId) {
            this.trackId = trackId;
            return this;
        }

        public Builder withDateOfRace(LocalDate dateOfRace) {
            this.dateOfRace = dateOfRace;
            return this;
        }

        public Builder withStandings(Set<RaceStanding> standings) {
            this.standings = standings;
            return this;
        }

        public Race build() {
            return new Race(this);
        }
    }
}
