package main.java.com.swc.vroomvroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DRIVER")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driverId;
    private String name;
    private String team;

}
