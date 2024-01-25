package main.java.com.swc.vroomvroom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TEAM")
public class Team {

    @Id
    @GeneratedValue
    private int id;
    private String name;
}
