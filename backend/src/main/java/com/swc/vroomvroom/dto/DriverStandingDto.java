package main.java.com.swc.vroomvroom.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DriverStandingDto {

    private int position;
    private String driverName;
    private int points;
    private String time;

    private DriverStandingDto(Builder builder) {
        position = builder.position;
        driverName = builder.driverName;
        points = builder.points;
        time = builder.time;
    }

    public int getPosition() {
        return position;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getPoints() {
        return points;
    }

    public String getTime() {
        return time;
    }

    public static final class Builder {
        private int position;
        private String driverName;
        private int points;
        private String time;

        public Builder withPosition(int position) {
            this.position = position;
            return this;
        }

        public Builder withDriverName(String driverName) {
            this.driverName = driverName;
            return this;
        }

        public Builder withPoints(int points) {
            this.points = points;
            return this;
        }

        public Builder withTime(String time) {
            this.time = time;
            return this;
        }

        public DriverStandingDto build() {
            return new DriverStandingDto(this);
        }
    }
}
