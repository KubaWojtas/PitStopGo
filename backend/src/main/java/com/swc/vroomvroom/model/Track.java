package main.java.com.swc.vroomvroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TRACK")
public class Track {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", nullable = false)
    private Calender calender;
}
