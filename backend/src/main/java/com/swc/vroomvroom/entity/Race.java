package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RACE")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int raceId;

}
