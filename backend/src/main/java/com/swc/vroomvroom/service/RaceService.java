package main.java.com.swc.vroomvroom.service;

import main.java.com.swc.vroomvroom.dto.RaceStandingDto;
import main.java.com.swc.vroomvroom.dto.SeasonResultsDto;
import main.java.com.swc.vroomvroom.entity.Driver;
import main.java.com.swc.vroomvroom.entity.Race;
import main.java.com.swc.vroomvroom.entity.RaceStanding;
import main.java.com.swc.vroomvroom.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RaceService {

    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private DriverService driverService;
    @Autowired
    private RaceStandingService raceStandingService;

    public Race getRaceById(int id) {
        return raceRepository.findById(id).orElse(null);
    }

    public List<Race> getAllRaces() {
        return (List<Race>) raceRepository.findAll();
    }

    public RaceStandingDto simulateRace(int raceId) {
        Race race = getRaceById(raceId);
        Map<Integer, Integer> standings = race.simulateRace(driverService.getAllDrivers());
        int[] pointsArray = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        int position = 1;
        int pointsIndex = 0;
        for (Map.Entry<Integer, Integer> standing : standings.entrySet()) {
            Driver driver = driverService.getDriverById(standing.getKey());
            RaceStanding raceStanding = new RaceStanding(driver, race);
            if (pointsIndex > 9) {
                raceStanding.setPoints(0);
            } else {
                raceStanding.setPoints(pointsArray[pointsIndex]);
            }
            raceStanding.setPosition(String.valueOf(position));
            raceStandingService.createRaceStanding(raceStanding);
            position++;
            pointsIndex++;
        }

        return raceStandingService.getRaceStandingById(raceId);
    }

    public SeasonResultsDto simulateAllRaces() {
        List<Race> races = getAllRaces();
        List<RaceStandingDto> standings= new ArrayList<>();
        for (Race race: races) {
            standings.add(simulateRace(race.getRaceId()));
        }
        SeasonResultsDto seasonResultsDto = new SeasonResultsDto();
        seasonResultsDto.createSeasonResults(standings);
        seasonResultsDto.sortStanding();
        return seasonResultsDto;
    }

    public Race createRace(Race race) {
        return raceRepository.save(race);
    }

}
