package main.java.com.swc.vroomvroom.dto;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class SeasonResultsDto {
    private List<DriverStandingDto> resultaten = new ArrayList<>();

    public void createSeasonResults(List<RaceStandingDto> raceStandings) {
        for (int i = 0; i < raceStandings.size(); i++) {
            RaceStandingDto race = raceStandings.get(i);
            for (DriverStandingDto raceStanding : race.getResultaten()) {
                if (i == 0) {
                    DriverStandingDto help = new DriverStandingDto();
                    help.setPoints(raceStanding.getPoints());
                    help.setDriverName(raceStanding.getDriverName());
                    resultaten.add(help);
                } else {
                    for (DriverStandingDto season : resultaten) {
                        if (season.getDriverName().equals(raceStanding.getDriverName())) {
                            season.setPoints(season.getPoints() + raceStanding.getPoints());
                        }
                    }
                }
            }
        }
        sortStanding();
        for (int ii = 1; ii <= getResultaten().size(); ii++) {
            getResultaten().get(ii-1).setPosition(ii);
        }
    }


    public void sortStanding() {
        Comparator<DriverStandingDto> comparator = Comparator.comparing(DriverStandingDto::getPoints).reversed();
        getResultaten().sort(comparator);
    }
}
