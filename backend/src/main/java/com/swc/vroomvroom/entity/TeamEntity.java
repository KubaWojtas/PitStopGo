package com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "team")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID teamId;
    private String name;
    private String country;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "teamId")
    private Set<DriverEntity> drivers = new HashSet<>();

    public void addDriver(DriverEntity driver) {
        drivers.add(driver);
    }

    public void removeDriver(DriverEntity driver) {
        drivers.remove(driver);
    }

}
