package main.java.com.swc.vroomvroom.service;

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
        for (RaceStanding r : raceStandings) {
            if (r.getRace().getRaceId() == id) {
                result.getResultaten().put(r.getDriver().getLastName(), r.getPoints());
            }
        }
        result.sortStanding();
        return result;
    }

    public void createRaceStanding(RaceStanding raceStanding) {
        raceStandingRepository.save(raceStanding);
    }
}
