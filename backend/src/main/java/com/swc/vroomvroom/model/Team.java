package main.java.com.swc.vroomvroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TEAM")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teamId;
    private String name;

}
