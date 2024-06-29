package main.java.com.swc.vroomvroom.dto;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class RaceStandingDto {
    private List<DriverStandingDto> resultaten = new ArrayList<>();

    public void sortStanding() {
        Comparator<DriverStandingDto> comparator = Comparator.comparing(DriverStandingDto::getPoints).reversed();
        getResultaten().sort(comparator);
    }
}
