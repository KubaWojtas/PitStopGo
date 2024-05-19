package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
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
        id = builder.id;
        driver = builder.driver;
        race = builder.race;
        position = builder.position;
        points = builder.points;
        time = builder.time;
    }

    public RaceStandingKey getId() {
        return id;
    }

    public Driver getDriver() {
        return driver;
    }

    public Race getRace() {
        return race;
    }

    public String getPosition() {
        return position;
    }

    public int getPoints() {
        return points;
    }

    public String getTime() {
        return time;
    }

    public static final class Builder {
        private RaceStandingKey id;
        private Driver driver;
        private Race race;
        private String position;
        private int points;
        private String time;

        public Builder() {
        }

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
