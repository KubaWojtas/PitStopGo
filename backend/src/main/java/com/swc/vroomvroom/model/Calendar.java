package main.java.com.swc.vroomvroom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "CALENDER")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int calendarId;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Track> tracks = new HashSet<>();

    public void addTrack(Track track) {
        tracks.add(track);
    }
}
