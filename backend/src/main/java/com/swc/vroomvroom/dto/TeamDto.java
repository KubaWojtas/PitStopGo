package com.swc.vroomvroom.dto;

import com.swc.vroomvroom.entity.DriverEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TeamDto {

    private UUID teamId;
    private String name;
    private String country;
    private Set<DriverEntity> drivers = new HashSet<>();

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

    public Set<DriverEntity> getDrivers() {
        return drivers;
    }

    public static final class Builder {
        private UUID teamId;
        private String name;
        private String country;
        private Set<DriverEntity> drivers;

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

        public Builder withDrivers(Set<DriverEntity> drivers) {
            this.drivers = drivers;
            return this;
        }

        public TeamDto build() {
            return new TeamDto(this);
        }
    }
}
