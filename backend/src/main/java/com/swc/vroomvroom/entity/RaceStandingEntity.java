package com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class RaceStandingEntity {

    @EmbeddedId
    RaceStandingEmbeddedKey id;

    @ManyToOne
    @MapsId("driverId")
    @JoinColumn(name = "driver_Id")
    private DriverEntity driver;

    @ManyToOne
    @MapsId("raceId")
    @JoinColumn(name = "race_Id")
    private RaceEntity race;

    private String position;
    private int points;
    private String time;

    public RaceStandingEntity(DriverEntity driver, RaceEntity race) {
        this.id = new RaceStandingEmbeddedKey(driver.getDriverId(), race.getRaceId());
        this.driver = driver;
        this.race = race;
    }

    private RaceStandingEntity(Builder builder) {
        setId(builder.id);
        setDriver(builder.driver);
        setRace(builder.race);
        setPosition(builder.position);
        setPoints(builder.points);
        setTime(builder.time);
    }

    public static final class Builder {

        private RaceStandingEmbeddedKey id;
        private DriverEntity driver;
        private RaceEntity race;
        private String position;
        private int points;
        private String time;

        public Builder withId(RaceStandingEmbeddedKey id) {
            this.id = id;
            return this;
        }

        public Builder withDriver(DriverEntity driver) {
            this.driver = driver;
            return this;
        }

        public Builder withRace(RaceEntity race) {
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

        public RaceStandingEntity build() {
            return new RaceStandingEntity(this);
        }
    }
}
