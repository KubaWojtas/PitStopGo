package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TRACK")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trackId;
    private String name;
    private String country;
    private String distance;
    private int laps;

}
