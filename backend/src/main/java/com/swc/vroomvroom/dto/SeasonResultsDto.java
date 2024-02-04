package main.java.com.swc.vroomvroom.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class SeasonResultsDto {
    private Map<String, Integer> resultaten = new HashMap<>();

    public void createSeasonResults(List<RaceStandingDto> raceStandings) {
        for (int i = 0; i < raceStandings.size(); i++) {
            RaceStandingDto race = raceStandings.get(i);
            for (Map.Entry<String, Integer> entry : race.getResultaten().entrySet()) {
                if (i == 0) {
                    resultaten.put(entry.getKey(), entry.getValue());
                } else {
                    for (Map.Entry<String, Integer> e : resultaten.entrySet()) {
                        if (e.getKey().equals(entry.getKey())) {
                            e.setValue(e.getValue() + entry.getValue());
                        }
                    }
                }
            }
        }
    }

    public void sortStanding() {
        setResultaten(resultaten.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
    }
}
