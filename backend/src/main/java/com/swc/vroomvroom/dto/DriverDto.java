package main.java.com.swc.vroomvroom.dto;

import lombok.Data;
import main.java.com.swc.vroomvroom.entity.RaceStanding;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class DriverDto {

    private UUID driverId;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String country;
    private String number;
    private int teamId;
    private Set<RaceStanding> standings;

    private DriverDto(Builder builder) {
        driverId = builder.driverId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        birthdate = builder.birthdate;
        country = builder.country;
        number = builder.number;
        teamId = builder.teamId;
        standings = builder.standings;
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

    public int getTeamId() {
        return teamId;
    }

    public Set<RaceStanding> getStandings() {
        return standings;
    }

    public static final class Builder {
        private UUID driverId;
        private String firstName;
        private String lastName;
        private LocalDate birthdate;
        private String country;
        private String number;
        private int teamId;
        private Set<RaceStanding> standings;

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

        public Builder withTeamId(int teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder withStandings(Set<RaceStanding> standings) {
            this.standings = standings;
            return this;
        }

        public DriverDto build() {
            return new DriverDto(this);
        }
    }
}
