package com.swc.vroomvroom.dto;

import lombok.Data;
import com.swc.vroomvroom.entity.Driver;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TeamDto {

    private UUID teamId;
    private String name;
    private String country;
    private Set<Driver> drivers = new HashSet<>();

    private TeamDto(Builder builder) {
        teamId = builder.teamId;
        name = builder.name;
        country = builder.country;
        drivers = builder.drivers;
    }

    public UUID getTeamId() {
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

    public static final class Builder {
        private UUID teamId;
        private String name;
        private String country;
        private Set<Driver> drivers;

        public Builder withTeamId(UUID teamId) {
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

        public TeamDto build() {
            return new TeamDto(this);
        }
    }
}
