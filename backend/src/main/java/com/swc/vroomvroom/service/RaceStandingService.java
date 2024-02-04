package main.java.com.swc.vroomvroom.service;

import main.java.com.swc.vroomvroom.dto.DriverStandingDto;
import main.java.com.swc.vroomvroom.dto.RaceStandingDto;
import main.java.com.swc.vroomvroom.entity.RaceStanding;
import main.java.com.swc.vroomvroom.repository.RaceStandingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceStandingService {

    @Autowired
    private RaceStandingRepository raceStandingRepository;

    public RaceStandingDto getRaceStandingById(int id) {
        List<RaceStanding> raceStandings = (List<RaceStanding>) raceStandingRepository.findAll();
        RaceStandingDto result = new RaceStandingDto();
        List<DriverStandingDto> resultaten = result.getResultaten();
        for (RaceStanding r : raceStandings) {
            if (r.getRace().getRaceId() == id) {
                DriverStandingDto driverStandingDto = new DriverStandingDto();
                driverStandingDto.setPosition(Integer.parseInt(r.getPosition()));
                driverStandingDto.setDriverName(r.getDriver().getLastName());
                driverStandingDto.setPoints(r.getPoints());
                resultaten.add(driverStandingDto);
            }
        }
        result.sortStanding();
        return result;
    }

    public void createRaceStanding(RaceStanding raceStanding) {
        raceStandingRepository.save(raceStanding);
    }
}
