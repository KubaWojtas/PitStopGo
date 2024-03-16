package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
}
