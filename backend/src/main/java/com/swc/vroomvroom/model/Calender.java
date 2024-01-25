package main.java.com.swc.vroomvroom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "CALENDER")
public class Calender {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "calender", cascade = CascadeType.ALL)
    private Set<Track> tracks;

}
