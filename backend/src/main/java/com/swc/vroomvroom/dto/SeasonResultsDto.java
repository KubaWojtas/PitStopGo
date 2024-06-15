package main.java.com.swc.vroomvroom.dto;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class SeasonResultsDto {
    private List<DriverStandingDto> resultaten = new ArrayList<>();

    private SeasonResultsDto(Builder builder) {
        resultaten = builder.resultaten;
    }

    public List<DriverStandingDto> getResultaten() {
        return resultaten;
    }

    public void createSeasonResults(List<RaceStandingDto> raceStandings) {
        for (int i = 0; i < raceStandings.size(); i++) {
            RaceStandingDto race = raceStandings.get(i);
            for (DriverStandingDto raceStanding : race.getResultaten()) {
                if (i == 0) {
                    DriverStandingDto help = new DriverStandingDto();
                    help.setPoints(raceStanding.getPoints());
                    help.setTime(raceStanding.getTime());
                    help.setDriverName(raceStanding.getDriverName());
                    resultaten.add(help);
                } else {
                    for (DriverStandingDto season : resultaten) {
                        if (season.getDriverName().equals(raceStanding.getDriverName())) {
                            season.setPoints(season.getPoints() + raceStanding.getPoints());
                            season.setTime(addTimes(season.getTime(), raceStanding.getTime()));
                        }
                    }
                }
            }
        }
        sortStanding();
        for (int ii = 1; ii <= getResultaten().size(); ii++) {
            getResultaten().get(ii - 1).setPosition(ii);
        }
    }

    public static String addTimes(String time1, String time2) {
        String[] parts1 = time1.split(":");
        String[] parts2 = time2.split(":");

        int hours1 = Integer.parseInt(parts1[0]);
        int minutes1 = Integer.parseInt(parts1[1]);
        double seconds1 = Double.parseDouble(parts1[2].replaceAll(",", "."));

        int hours2 = Integer.parseInt(parts2[0]);
        int minutes2 = Integer.parseInt(parts2[1]);
        double seconds2 = Double.parseDouble(parts2[2].replaceAll(",", "."));

        int sumHours = hours1 + hours2;
        int sumMinutes = minutes1 + minutes2;
        double sumSeconds = seconds1 + seconds2;

        if (sumSeconds >= 60) {
            sumSeconds -= 60;
            sumMinutes++;
        }
        if (sumMinutes >= 60) {
            sumMinutes -= 60;
            sumHours++;
        }

        return String.format("%02d:%02d:%06.3f", sumHours, sumMinutes, sumSeconds);
    }


    public void sortStanding() {
        Comparator<DriverStandingDto> comparator = Comparator.comparing(DriverStandingDto::getPoints).reversed();
        getResultaten().sort(comparator);
    }

    public static final class Builder {
        private List<DriverStandingDto> resultaten;

        public Builder withResultaten(List<DriverStandingDto> resultaten) {
            this.resultaten = resultaten;
            return this;
        }

        public SeasonResultsDto build() {
            return new SeasonResultsDto(this);
        }
    }
}
