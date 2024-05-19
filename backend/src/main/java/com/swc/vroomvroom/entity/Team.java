package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TEAM")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;
    private String name;
    private String country;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "teamId")
    private Set<Driver> drivers = new HashSet<>();

    private Team(Builder builder) {
        teamId = builder.teamId;
        name = builder.name;
        country = builder.country;
        drivers = builder.drivers;
    }


    public int getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    public static final class Builder {
        private int teamId;
        private String name;
        private String country;
        private Set<Driver> drivers;

        public Builder() {
        }

        public Builder withTeamId(int teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder withDrivers(Set<Driver> drivers) {
            this.drivers = drivers;
            return this;
        }

        public Team build() {
            return new Team(this);
        }
    }
}
