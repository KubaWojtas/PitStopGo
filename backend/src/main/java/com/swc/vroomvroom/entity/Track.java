package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;
import main.java.com.swc.vroomvroom.domain.TrackType;

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
    private String location;
    private String country;
    private double distance;
    private float lapRecord;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "trackId")
    private Set<Race> races = new HashSet<>();

    public void addRace(Race race) {
        races.add(race);
    }

    public void removeRace(Race race) {
        races.remove(race);
    }

    public int getLaps() {
        return (int) Math.ceil(305/distance) + 1;
    }
}
