package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "TRACK")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trackId;
    private String name;
    private String country;
    private String distance;
    private int laps;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Race> races = new HashSet<>();

    public void addRace(Race race) {
        races.add(race);
    }

    public void removeRace(Race race) {
        races.remove(race);
    }
}
