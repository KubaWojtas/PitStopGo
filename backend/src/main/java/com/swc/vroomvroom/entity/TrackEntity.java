package com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Data
@Entity
@Table(name = "track")
public class TrackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID trackId;
    private String name;
    private String location;
    private String country;
    private double distance;
    private float lapRecord;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "trackId")
    private Set<RaceEntity> races = new HashSet<>();

    public void addRace(RaceEntity race) {
        races.add(race);
    }

    public void removeRace(RaceEntity race) {
        races.remove(race);
    }

    public int getLaps() {
        return (int) Math.ceil(305/distance) + 1;
    }
}
