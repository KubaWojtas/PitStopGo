package main.java.com.swc.vroomvroom.dto;

import lombok.Data;
import main.java.com.swc.vroomvroom.entity.Race;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CalanderDto {

    private UUID calendarId;
    private String name;
    private Set<Race> races = new HashSet<>();

    private CalanderDto(Builder builder) {
        calendarId = builder.calendarId;
        name = builder.name;
        races = builder.races;
    }

    public UUID getCalendarId() {
        return calendarId;
    }

    public String getName() {
        return name;
    }

    public Set<Race> getRaces() {
        return races;
    }

    public static final class Builder {
        private UUID calendarId;
        private String name;
        private Set<Race> races;

        public Builder withCalendarId(UUID calendarId) {
            this.calendarId = calendarId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withRaces(Set<Race> races) {
            this.races = races;
            return this;
        }

        public CalanderDto build() {
            return new CalanderDto(this);
        }
    }
}
