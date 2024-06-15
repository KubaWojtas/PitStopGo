package main.java.com.swc.vroomvroom.dto;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class RaceStandingDto {
    private List<DriverStandingDto> resultaten = new ArrayList<>();

    private RaceStandingDto(Builder builder) {
        resultaten = builder.resultaten;
    }

    public void sortStanding() {
        Comparator<DriverStandingDto> comparator = Comparator.comparing(DriverStandingDto::getPoints).reversed();
        getResultaten().sort(comparator);
    }

    public List<DriverStandingDto> getResultaten() {
        return resultaten;
    }

    public static final class Builder {
        private List<DriverStandingDto> resultaten;

        public Builder withResultaten(List<DriverStandingDto> resultaten) {
            this.resultaten = resultaten;
            return this;
        }

        public RaceStandingDto build() {
            return new RaceStandingDto(this);
        }
    }
}
