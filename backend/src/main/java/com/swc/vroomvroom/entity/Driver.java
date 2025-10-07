package com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID driverId;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String country;
    private String number;
    private UUID teamId;
    private int winChangeMin;
    private int winChangeMax;

    @OneToMany(mappedBy = "driver")
    private Set<RaceStanding> standings;

    public Driver() {}

    private Driver(Builder builder) {
        driverId = builder.driverId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        birthdate = builder.birthdate;
        country = builder.country;
        number = builder.number;
        teamId = builder.teamId;
        winChangeMin = builder.winChangeMin;
        winChangeMax = builder.winChangeMax;
    }

    public UUID getDriverId() {
        return driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getCountry() {
        return country;
    }

    public String getNumber() {
        return number;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public int getWinChangeMin() {
        return winChangeMin;
    }

    public int getWinChangeMax() {
        return winChangeMax;
    }

    public Set<RaceStanding> getStandings() {
        return standings;
    }

    public void addStandings(RaceStanding raceStanding) {
        standings.add(raceStanding);
    }

    public static final class Builder {
        private UUID driverId;
        private String firstName;
        private String lastName;
        private LocalDate birthdate;
        private String country;
        private String number;
        private UUID teamId;
        private int winChangeMin;
        private int winChangeMax;

        public Builder withDriverId(UUID driverId) {
            this.driverId = driverId;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withBirthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder withNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder withTeamId(UUID teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder withWinChangeMin(int winChangeMin) {
            this.winChangeMin = winChangeMin;
            return this;
        }

        public Builder withWinChangeMax(int winChangeMax) {
            this.winChangeMax = winChangeMax;
            return this;
        }

        public Driver build() {
            return new Driver(this);
        }
    }
}
