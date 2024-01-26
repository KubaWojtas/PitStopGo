package main.java.com.swc.vroomvroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TRACK")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trackId;
    private String name;

    public Track() {

    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
