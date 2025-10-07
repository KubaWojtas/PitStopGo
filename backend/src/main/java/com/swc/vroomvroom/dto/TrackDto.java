package com.swc.vroomvroom.dto;

import lombok.Data;
import com.swc.vroomvroom.entity.Race;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TrackDto {

    private UUID trackId;
    private String name;
    private String location;
    private String country;
    private double distance;
    private float lapRecord;
    private Set<Race> races = new HashSet<>();

    private TrackDto(Builder builder) {
        trackId = builder.trackId;
        name = builder.name;
        location = builder.location;
        country = builder.country;
        distance = builder.distance;
        lapRecord = builder.lapRecord;
        races = builder.races;
    }

    public UUID getTrackId() {
        return trackId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCountry() {
        return country;
    }

    public double getDistance() {
        return distance;
    }

    public float getLapRecord() {
        return lapRecord;
    }

    public Set<Race> getRaces() {
        return races;
    }

    public static final class Builder {
        private UUID trackId;
        private String name;
        private String location;
        private String country;
        private double distance;
        private float lapRecord;
        private Set<Race> races;

        public Builder withTrackId(UUID trackId) {
            this.trackId = trackId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder withDistance(double distance) {
            this.distance = distance;
            return this;
        }

        public Builder withLapRecord(float lapRecord) {
            this.lapRecord = lapRecord;
            return this;
        }

        public Builder withRaces(Set<Race> races) {
            this.races = races;
            return this;
        }

        public TrackDto build() {
            return new TrackDto(this);
        }
    }
}
