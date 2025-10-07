package com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class RaceStanding {

    @EmbeddedId
    RaceStandingKey id;

    @ManyToOne
    @MapsId("driverId")
    @JoinColumn(name = "driver_Id")
    private Driver driver;

    @ManyToOne
    @MapsId("raceId")
    @JoinColumn(name = "race_Id")
    private Race race;

    private String position;
    private int points;
    private String time;

    public RaceStanding(Driver driver, Race race) {
        this.id = new RaceStandingKey(driver.getDriverId(), race.getRaceId());
        this.driver = driver;
        this.race = race;
    }

    private RaceStanding(Builder builder) {
        setId(builder.id);
        setDriver(builder.driver);
        setRace(builder.race);
        setPosition(builder.position);
        setPoints(builder.points);
        setTime(builder.time);
    }

    public static final class Builder {

        private RaceStandingKey id;
        private Driver driver;
        private Race race;
        private String position;
        private int points;
        private String time;

        public Builder withId(RaceStandingKey id) {
            this.id = id;
            return this;
        }

        public Builder withDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public Builder withRace(Race race) {
            this.race = race;
            return this;
        }

        public Builder withPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder withPoints(int points) {
            this.points = points;
            return this;
        }

        public Builder withTime(String time) {
            this.time = time;
            return this;
        }

        public RaceStanding build() {
            return new RaceStanding(this);
        }
    }
}
