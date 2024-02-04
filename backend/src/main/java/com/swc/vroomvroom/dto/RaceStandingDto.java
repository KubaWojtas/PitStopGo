package main.java.com.swc.vroomvroom.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class RaceStandingDto {
    private Map<String, Integer> resultaten = new HashMap<>();

    public void sortStanding() {
        setResultaten(resultaten.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
    }
}
