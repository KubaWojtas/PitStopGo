package main.java.com.swc.vroomvroom.dto;

import lombok.Data;
import main.java.com.swc.vroomvroom.entity.RaceStanding;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class RaceDto {

    private UUID raceId;
    private int calendarId;
    private int trackId;
    private LocalDate dateOfRace;
    private Set<RaceStanding> standings;

    private RaceDto(Builder builder) {
        raceId = builder.raceId;
        calendarId = builder.calendarId;
        trackId = builder.trackId;
        dateOfRace = builder.dateOfRace;
        standings = builder.standings;
    }

    public UUID getRaceId() {
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

    public static final class Builder {
        private UUID raceId;
        private int calendarId;
        private int trackId;
        private LocalDate dateOfRace;
        private Set<RaceStanding> standings;

        public Builder withRaceId(UUID raceId) {
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

        public RaceDto build() {
            return new RaceDto(this);
        }
    }
}
